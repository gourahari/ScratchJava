package com.goura.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GCTest {

    private String classVar = "Welcome";
    private static final String STATIC_VAR = "Hello World";
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<String>();

        Thread.sleep(20000);

        System.out.println("Starting profiling the app."); 
        while (true) {
            Thread.sleep(1);
            int rand = random(1, 20);
            if (rand % 2 == 0) {
                for (int i = 0; i < random(25, 50); i++) {
                    String s = new String("L-" + i + - + rand);
                }
            }
            for (int i = 0; i < 20; i++) {
                list.add(new String("A-" + i + - + rand));
            }
            
            for (int i = 5; i < 25; i++) {
                list.remove(new String("A-" + i + - + rand));
            }
        }
    }

    public static int random(int min, int max) {
        return random.nextInt(max + 1 - min) + min;
    }
}
