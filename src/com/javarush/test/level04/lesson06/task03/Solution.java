package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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

        if (f1 > f2 && f2 > f3 && f1 > f3)   System.out.println(f1 + " " + f2 + " " + f3);
            else if (f1 > f2 && f2 < f3 && f1 > f3)   System.out.println(f1 + " " + f3 + " " + f2);

                else if (f1 < f2 && f1 < f3 && f2 > f3)   System.out.println(f2 + " " + f3 + " " + f1);
                    else if (f1 < f2 && f1 > f3 && f2 > f3)   System.out.println(f2 + " " + f1 + " " + f3);
                        else if (f3 > f2 && f1 < f2 && f3 > f1)   System.out.println(f3 + " " + f2 + " " + f1);
                            else if (f3 > f2 && f1 > f2 && f3 > f1)   System.out.println(f3 + " " + f1 + " " + f2);


    }
}
