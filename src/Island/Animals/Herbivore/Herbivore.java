package Island.Animals.Herbivore;

import Island.Animals.Animal;
import Island.Grass;

import java.util.ArrayList;

public abstract class Herbivore extends Animal {
    @Override
    public void eat(ArrayList<Object> arrayList) {
        for (Object ob :
                arrayList) {
            if (ob instanceof Animal) continue;
            else if (ob instanceof Grass) {
                ((Grass) ob).delete(arrayList);
                break;
            }
        }
    }
}
