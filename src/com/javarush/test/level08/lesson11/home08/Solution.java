package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        int  maxInd = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int index = i; index < array.length; index++) {
                if (array[index] > array[maxInd]) {
                    maxInd = index;
                }
            }
            int tmp = array[i];
            array[i] = array[maxInd];
            array[maxInd] = tmp;
            maxInd = i+1;
        }
    }
}
