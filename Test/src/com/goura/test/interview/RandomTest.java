package com.goura.test.interview;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int rand5 = random5();
            System.out.print(rand5);
            System.out.println("  " + random7(rand5));
        }
    }

    private static int random7(int random5) {
        return (int) (random5 * 7/5);
    }

    private static int random5() {
        return new Random().nextInt(5) + 1;
    }
}
