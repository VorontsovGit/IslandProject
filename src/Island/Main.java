package Island;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Введите длину");
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        System.out.print("Введите ширину");
        int height = scanner.nextInt();
        System.out.print("Количество тактов работы симуляции");
        int workTime = scanner.nextInt();
        System.out.println("");

        Island island = new Island(width, height);

        for (int i = 1; i < workTime + 1; i++) {

            AtomicInteger birthCount = new AtomicInteger();
            AtomicInteger eatCount = new AtomicInteger();
            AtomicInteger moveCount = new AtomicInteger();
            System.out.println("Такт № " + i);
            Arrays.stream(island.getIsland())
                    .forEach(arrayLists -> Arrays.stream(arrayLists)
                            .forEach(arrayList -> {
                                eatCount.set(island.eatCycle(arrayList));
                                Grass.addGrass(arrayList);
                                birthCount.set(island.multiplyAnimals(arrayList));
                                //moveCount.set(island.moveAnimals(island));
                            }));
            island.islandLifeCount();
            System.out.println("");
            System.out.println("Было рождено " + birthCount);
            System.out.println("Было съедено " + eatCount);
            System.out.println("Мигрировали " + moveCount);
            System.out.println("");
            Thread.sleep(3000);
            }
        }
}
