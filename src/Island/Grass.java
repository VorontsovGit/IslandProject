package Island;

import java.util.ArrayList;
import java.util.Iterator;

public class Grass {
    private static final int maxQuantity = 10_000;

    public static ArrayList<Object> create(){
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < maxQuantity; i++) {
            arrayList.add(new Grass());
        }
        return arrayList;
    }

    public static void addGrass(ArrayList<Object> arrayList){
        int count = (int) arrayList.stream().filter(ob -> ob instanceof Grass).count();
        if(count <= maxQuantity){
            for (int i = 0; i < maxQuantity - count; i++) {
                arrayList.add(new Grass());
            }
        }
    }
    public void delete(ArrayList<Object> arrayList){
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if (o instanceof Grass) {
                iterator.remove();
                break;
            }
        }
    }
}
