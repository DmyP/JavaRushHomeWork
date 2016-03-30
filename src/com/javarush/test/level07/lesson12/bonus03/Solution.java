package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        int maxInd = array[0];
        for (int barrier = 0; barrier < array.length - 1; barrier++) {
            for (int index = barrier; index < array.length; index++) {
                if (array[index] > array[maxInd]) {
                    maxInd = index;
                }
            }
            int tmp = array[barrier];
            array[barrier] = array[maxInd];
            array[maxInd] = tmp;
            maxInd = barrier+1;

        }
    }
}
