package com.javarush.test.level04.lesson06.task08;

/* Координатные четверти
Ввести с клавиатуры два целых числа, которые будут координатами точки, не лежащей на координатных осях OX и OY.
Вывести на экран номер координатной четверти, в которой находится данная точка.
Подсказка:
Принадлежность точки с координатами (a,b) к одной из четвертей определяется следующим образом:
для первой четверти a>0 и b>0;
для второй четверти a<0 и b>0;
для третьей четверти a<0 и b<0;
для четвертой четверти a>0 и b<0.
Пример для чисел 4 6:
1
Пример для чисел -6 -6:
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
        int f1 = Integer.parseInt(s1);
        int f2 = Integer.parseInt(s2);
        if ((f1 > 0) && (f2 > 0)) System.out.println(1);
            else if ((f1 < 0) && (f2 > 0)) System.out.println(2);
                else if ((f1 < 0) && (f2 < 0)) System.out.println(3);
                    else if ((f1 > 0) && (f2 < 0)) System.out.println(4);


    }
}
