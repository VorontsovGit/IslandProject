package Island.Animals.Predators;

import Island.Animals.Animal;
import Island.Island;
import java.util.ArrayList;

public abstract class Predators extends Animal {

    @Override
    public void eat(ArrayList<Object> arrayList) {}

    @Override
    public int move(Island island){
        return 0;
    }

    public static ArrayList create(){
        return new ArrayList<>();
    }
}
