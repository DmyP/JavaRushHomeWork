package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
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
        int f1 = Integer.parseInt(s1);
        int f2 = Integer.parseInt(s2);
        int f3 = Integer.parseInt(s3);
        if (f1 == f2) System.out.println(3);
        else if (f1 == f3) System.out.println(2);
        else if (f2 == f3) System.out.println(1);


    }
}
