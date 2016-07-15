package com.javarush.test.level38.lesson04.task01;

/* Проверяемые исключения (checked exception)
Напиши реализацию метода veryComplexMethod().
Он должен всегда кидать какое-нибудь проверяемое исключение.
Кинуть исключение (throw) явно нельзя.
*/

import java.io.FileInputStream;
import java.util.Random;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        Random rand = new Random();
        switch (rand.nextInt(2)) {
            case 0:
                FileInputStream stream = new FileInputStream("x");
            case 1:
                int i = 10 / 0;
            case 2:
                int[] arr = new int[1];
                System.out.println(arr[2]);
        }
    }
}
