package com.javarush.test.level18.lesson03.task03;


/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        int []bytes = new int[256];
        int max = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIS = new FileInputStream(reader.readLine());

        while (fileIS.available() > 0) {
            int i = fileIS.read();
            bytes[i]++;
            if (bytes[i] > max) max = bytes[i];
        }

        for (int i = 0; i < 255; i++) {
            if (bytes[i] == max) System.out.print(i + " ");
        }

        fileIS.close();
        reader.close();
    }
}
