package Island.Animals.Herbivore;

import Island.Island;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Horse extends Herbivore {
    private static int maxQuantity = 23;

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
            arrayList.add(new Horse());
        }
        return arrayList;
    }

    public void delete(ArrayList<Object> arrayList){
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if (o instanceof Horse) {
                iterator.remove();
                break;
            }
        }
    }

    public static int multiply(HashSet arrayList) {
        long count = arrayList.stream().filter(x -> x instanceof Horse).count();
        int returnedCount = 0;
        //Деление на 3 и умножение на 2 сделано для того, чтобы количество животных не превышало максимум
        if (count > 1 && count < (maxQuantity / 3) * 2){
            for (int i = 0; i < count / 2; i++) {
                arrayList.add(new Horse());
                returnedCount++;
            }
        }
        return returnedCount;
    }
}
