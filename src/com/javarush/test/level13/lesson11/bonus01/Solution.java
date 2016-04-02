package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException {
        String str = "";
        int i = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        FileReader inStream = new FileReader(bufferedReader.readLine());
        BufferedReader bufferedReader2 = new BufferedReader(inStream);

        while ((str = bufferedReader2.readLine())!= null)
        {
            i = Integer.parseInt(str);
            if (i % 2 == 0) {
                list.add(i);
            }
        }
        Collections.sort(list);
        for (int j: list) {
            System.out.println(j);
        }



        bufferedReader.close();
        bufferedReader2.close();
    }
}
