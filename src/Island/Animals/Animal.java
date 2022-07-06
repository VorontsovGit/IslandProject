package Island.Animals;

import Island.Island;

import java.util.ArrayList;

public abstract class Animal {
    public static int maxQuantity;

    public static int multiply(ArrayList arrayList){
        return 0;
    }
    public abstract void eat(ArrayList<Object> arrayList);

    public int move(Island island){
        return 0;
    }
}
