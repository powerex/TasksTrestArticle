package ua.azbest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PairToys {

    static Random gen = new Random();
    static final int EXPERIMENTS = 1000;
    static final int TOY_COUNT = 50;

    public static void main(String[] args) {

        Map<Integer, Integer> distribution = new HashMap<>();

        for (int i=0; i<EXPERIMENTS; ++i) {

            int key = 0;
            try {
                key = getCountPurchases();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (distribution.containsKey(key)) {
                distribution.put(key, distribution.get(key)+1);
            } else {
                distribution.put(key, 1);
            }

        }

        for (Integer key: distribution.keySet()) {
            System.out.println(key + ": " + distribution.get(key));
        }

    }

    public static int getCountPurchases() throws InterruptedException {
        int firstNumber = gen.nextInt(TOY_COUNT);
        Thread.sleep(10);
        int countPurchases = 1;
        while (gen.nextInt(TOY_COUNT) != firstNumber) {
            Thread.sleep(gen.nextInt(10)+2);
            countPurchases++;
        }
        return countPurchases;
    }

}
