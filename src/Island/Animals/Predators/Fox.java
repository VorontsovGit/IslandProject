package Island.Animals.Predators;

import Island.Animals.Animal;
import Island.Animals.Herbivore.*;
import Island.Island;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Fox extends Predators{

    private static final int maxQuantity = 50;
    private static final int moveSpeed = 2;
    double satiety = 1;

    /**
     * Метод для размножения животных
     * @param arrayList Локация, в которой будут размножаться животные
     */
    public static int multiply(HashSet arrayList) {
        long count = arrayList.stream().filter(x -> x instanceof Fox).count();
        int returnedCount = 0;
        //Деление на 3 и умножение на 2 сделано для того, чтобы количество животных не превышало максимум
        if (count > 1 && count < (maxQuantity / 3) * 2){
            for (int i = 0; i < count / 2; i++) {
                arrayList.add(new Fox());
                returnedCount++;
            }
        }
        return returnedCount;
    }

    @Override
    public void eat(ArrayList<Object> arrayList) {
        Object o = null;
        try {
            o = arrayList.stream().filter(ob -> ob instanceof Animal).findAny().get();
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        double chanceToEat = Math.random() * 10;
        if(chanceToEat <= 0.5){
            if(o instanceof Kangaroo) ((Kangaroo) o).delete(arrayList);
            else if (o instanceof Deer) ((Deer) o).delete(arrayList);
        }
        else if(chanceToEat <= 1){
            if (o instanceof Eagle) ((Eagle) o).delete(arrayList);
        }
        else if(chanceToEat <= 2){
            if(o instanceof Snake) ((Snake) o).delete(arrayList);
            else if (o instanceof Coat) ((Coat) o).delete(arrayList);
            else if (o instanceof Sheep) ((Sheep) o).delete(arrayList);
        }
        else if (chanceToEat <= 7) {
            if (o instanceof Rabbit) ((Rabbit) o).delete(arrayList);
        }
        else if(chanceToEat <= 8){
            if (o instanceof Duck) ((Duck) o).delete(arrayList);
        }
        else if(chanceToEat <= 9){
            if (o instanceof Hamster) ((Hamster) o).delete(arrayList);
        }
        else satiety -= 0.5;
    }

    /**
     * Метод для первоначального заселения локации
     * @return список с максимальным количеством животных на локации
     */
    public static ArrayList create(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < maxQuantity; i++) {
            arrayList.add(new Fox());
        }
        return arrayList;
    }

    /**
     * Метод, чтобы удалить животное с локации при необходимости
     *
     * @param arrayList локация, с которой удаляем животное
     */
    public void delete(ArrayList<Object> arrayList){
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if (o instanceof Fox) {
                iterator.remove();
                break;
            }
        }
    }


    @Override
    public int move(Island island) {
        int moveCount = 0;
        if(satiety < 0) {
            for (int i = 0; i < island.getWidth(); i++) {
                for (int j = 0; j < island.getHeight(); j++) {
                    Iterator iterator = island.getLocation(i, j).iterator();
                    Object o = iterator.next();
                    while (iterator.hasNext()) {
                        if (o instanceof Fox) {
                        /* Переменная moveDirection отвечает за выбор направления движения, ограничена от 0
                        до 3. Соответственно 0 - на север, 1 - на восток, 2 - на юг, 3 - на запад.
                         */
                            double d = (Math.random() * 10) / 3.5;
                            int moveDirection = (int) Math.round(d);
                            switch (moveDirection) {
                                case 0 -> {
                                    ((Fox) o).delete(island.getLocation(i, j));
                                    island.getLocation(i - moveSpeed, j).add(new Fox());
                                }
                                case 1 -> {
                                    ((Fox) o).delete(island.getLocation(i, j));
                                    island.getLocation(i, j + moveSpeed).add(new Fox());
                                }
                                case 2 -> {
                                    ((Fox) o).delete(island.getLocation(i, j));
                                    island.getLocation(i + moveSpeed, j).add(new Fox());
                                }
                                case 3 -> {
                                    ((Fox) o).delete(island.getLocation(i, j));
                                    island.getLocation(i, j - moveSpeed).add(new Fox());
                                }
                            }
                            moveCount++;
                        }
                    }
                }
            }
        }
        return moveCount;
    }
}
