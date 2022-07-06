package Island.Animals.Herbivore;

import Island.Island;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Rabbit extends Herbivore{
    private static int maxQuantity = 750;

    @Override
    public void eat(ArrayList<Object> arrayList) {
        super.eat(arrayList);
    }

    @Override
    public int move(Island island) {
        return 0;
    }

    public static ArrayList create(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < maxQuantity; i++) {
            arrayList.add(new Rabbit());
        }
        return arrayList;
    }

    public void delete(ArrayList<Object> arrayList){
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if (o instanceof Rabbit) {
                iterator.remove();
                break;
            }
        }
    }

    public static int multiply(HashSet arrayList) {
        long count = arrayList.stream().filter(x -> x instanceof Rabbit).count();
        int returnedCount = 0;
        //Деление на 3 и умножение на 2 сделано для того, чтобы количество животных не превышало максимум
        if (count > 1 && count < (maxQuantity / 3) * 2){
            for (int i = 0; i < count / 2; i++) {
                arrayList.add(new Rabbit());
                returnedCount++;
            }
        }
        return returnedCount;
    }
}
