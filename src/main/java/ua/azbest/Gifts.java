package ua.azbest;

import java.util.Random;

public class Gifts {

    static final int GIFTS = 20;
    static final int EXPERIMENTS = 10000;
    static final Random gen = new Random();

    public static void main(String[] args) {

        int[] array = new int[GIFTS];
        for (int i=0; i<GIFTS; ++i) {
            array[i] = i;
        }

        int count = 0;

        for (int i=0; i<EXPERIMENTS; ++i) {
            shuffle(array);
            if (countCoincidences(array) > 0)
                count++;
        }

        System.out.println("Absolute:\t" + count);
        System.out.println("Relative:\t" + (double)count/EXPERIMENTS);

    }

    public static void shuffle(int[] array) {
        for (int i=0; i<array.length; ++i) {
            int j = gen.nextInt(array.length);
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }

    public static int countCoincidences(int[] array) {
        int count = 0;
        for (int i=0; i<array.length; ++i) {
            if (array[i] == i)
                count++;
        }
        return count;
    }

}
