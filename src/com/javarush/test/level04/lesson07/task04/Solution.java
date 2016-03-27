package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int counterPos = 0;
        int counterNeg = 3;
        if (Integer.parseInt(s1) >= 0) counterPos++;
        if (Integer.parseInt(s2) >= 0) counterPos++;
        if (Integer.parseInt(s3) >= 0) counterPos++;
        counterNeg = counterNeg - counterPos;
        System.out.println("количество отрицательных чисел: " + counterNeg);
        System.out.println("количество положительных чисел: " + counterPos);

    }
}
