package Island;

import Island.Animals.Predators.*;
import Island.Animals.Herbivore.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Island {
    int width;
    int height;
    ArrayList<Object>[][] island;

    Island(int width, int height) {
        this.width = width;
        this.height = height;
        island = new ArrayList[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.addAll(Wolf.create());
                arrayList.addAll(Eagle.create());
                arrayList.addAll(Kangaroo.create());
                arrayList.addAll(Cow.create());
                arrayList.addAll(Horse.create());
                arrayList.addAll(Snake.create());
                arrayList.addAll(Fox.create());
                arrayList.addAll(Deer.create());
                arrayList.addAll(Bear.create());
                arrayList.addAll(Rabbit.create());
                arrayList.addAll(Caterpillar.create());
                arrayList.addAll(Coat.create());
                arrayList.addAll(Duck.create());
                arrayList.addAll(Hamster.create());
                arrayList.addAll(Sheep.create());
                Collections.shuffle(arrayList);

                island[i][j] = arrayList;
            }
        }
    }

    public ArrayList<Object>[][] getIsland() {
        return island;
    }

    /**
     * Метод для получения определённой локации
     *
     * @param width  Координата "х" нужной локации
     * @param height Координата "у" нужной локации
     * @return Локация по переданным индексам
     */
    public ArrayList<Object> getLocation(int width, int height) {
        return island[width][height];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void islandLifeCount() {
        long wolfCount = 0;
        long eagleCount = 0;
        long snakeCount = 0;
        long foxCount = 0;
        long bearCount = 0;
        long kangarooCount = 0;
        long cowCount = 0;
        long horseCount = 0;
        long deerCount = 0;
        long rabbitCount = 0;
        long caterpillarCount = 0;
        long coatCount = 0;
        long duckCount = 0;
        long hamsterCount = 0;
        long sheepCount = 0;
        long grassCount = 0;
        for (ArrayList[] arrayLists : island) {
            for (ArrayList arrayList : arrayLists) {
                wolfCount += arrayList.stream().filter(x -> x instanceof Wolf).count();
                eagleCount += arrayList.stream().filter(x -> x instanceof Eagle).count();
                grassCount += arrayList.stream().filter(x -> x instanceof Grass).count();
                kangarooCount += arrayList.stream().filter(x -> x instanceof Kangaroo).count();
                cowCount += arrayList.stream().filter(x -> x instanceof Cow).count();
                horseCount += arrayList.stream().filter(x -> x instanceof Horse).count();
                snakeCount += arrayList.stream().filter(x -> x instanceof Snake).count();
                foxCount += arrayList.stream().filter(x -> x instanceof Fox).count();
                deerCount += arrayList.stream().filter(x -> x instanceof Deer).count();
                rabbitCount += arrayList.stream().filter(x -> x instanceof Rabbit).count();
                bearCount += arrayList.stream().filter(x -> x instanceof Bear).count();
                caterpillarCount += arrayList.stream().filter(x -> x instanceof Caterpillar).count();
                coatCount += arrayList.stream().filter(x -> x instanceof Coat).count();
                duckCount += arrayList.stream().filter(x -> x instanceof Duck).count();
                hamsterCount += arrayList.stream().filter(x -> x instanceof Hamster).count();
                sheepCount += arrayList.stream().filter(x -> x instanceof Sheep).count();
            }
        }
        System.out.println("Волков " + wolfCount);
        System.out.println("Орлов " + eagleCount);
        System.out.println("Кенгуру " + kangarooCount);
        System.out.println("Коров " + cowCount);
        System.out.println("Лошадей " + horseCount);
        System.out.println("Растений " + grassCount);
        System.out.println("Змей " + snakeCount);
        System.out.println("Лисиц " + foxCount);
        System.out.println("Медведей  " + bearCount);
        System.out.println("Оленей " + deerCount);
        System.out.println("Зайцев " + rabbitCount);
        System.out.println("Гусениц " + caterpillarCount);
        System.out.println("Коз " + coatCount);
        System.out.println("Утой " + duckCount);
        System.out.println("Хомячков " + hamsterCount);
        System.out.println("Овец " + sheepCount);
    }

    public int eatCycle(ArrayList<Object> arrayList) {
        int returnedCount = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            Object o = arrayList.get(i);
            if (o instanceof Herbivore) {
                ((Herbivore) o).eat(arrayList);
                returnedCount++;
            }
            else if (o instanceof Wolf) {
                ((Wolf) o).eat(arrayList);
                returnedCount++;
            }
            else if (o instanceof Eagle){
                ((Eagle) o).eat(arrayList);
                returnedCount++;
            }
            else if (o instanceof Snake) {
                ((Snake) o).eat(arrayList);
                returnedCount++;
            }
            else if (o instanceof Fox) {
                ((Fox) o).eat(arrayList);
                returnedCount++;
            }
            else if (o instanceof Bear) {
                ((Bear) o).eat(arrayList);
                returnedCount++;
            }
        }
        return returnedCount;
    }

    public int multiplyAnimals(ArrayList arrayList) {
        int count = Wolf.multiply(arrayList);
        count += Eagle.multiply(arrayList);
        count += Kangaroo.multiply(arrayList);
        count += Horse.multiply(arrayList);
        count += Cow.multiply(arrayList);
        count += Caterpillar.multiply(arrayList);
        count += Coat.multiply(arrayList);
        count += Deer.multiply(arrayList);
        count += Duck.multiply(arrayList);
        count += Hamster.multiply(arrayList);
        count += Sheep.multiply(arrayList);
        count += Rabbit.multiply(arrayList);
        count += Fox.multiply(arrayList);
        count += Snake.multiply(arrayList);
        count += Bear.multiply(arrayList);
        return count;
    }

    public int moveAnimals(Island island) {
        AtomicInteger moveCount = new AtomicInteger();
        Arrays.stream(island.getIsland())
                .forEach(arrayLists -> Arrays.stream(arrayLists)
                        .forEach(arrayList -> arrayList.stream()
                                .forEach(x -> {
                                    if (x instanceof Bear){
                                        ((Bear) x).move(island);
                                        moveCount.getAndIncrement();
                                    }
                                    else if (x instanceof Fox) {
                                        ((Fox) x).move(island);
                                        moveCount.getAndIncrement();
                                    }
                                    else if (x instanceof Wolf) {
                                        ((Wolf) x).move(island);
                                        moveCount.getAndIncrement();
                                    }
                                    else if (x instanceof Snake) {
                                        ((Snake) x).move(island);
                                        moveCount.getAndIncrement();
                                    }
                                    else if (x instanceof Eagle) {
                                        ((Eagle) x).move(island);
                                        moveCount.getAndIncrement();
                                    }
                                })));
        return moveCount.get();
    }
}
