package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int []bytes = new int[256];
        int min = Integer.MAX_VALUE;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIS = new FileInputStream(reader.readLine());

        while (fileIS.available() > 0) {
            int i = fileIS.read();
            bytes[i]++;
        }

        for (int i = 1; i < 255; i++) {
            if ((bytes[i] > 0) && (bytes[i] < min)) min = bytes[i];
        }

        for (int i = 0; i < 255; i++) {
            if (bytes[i] == min) System.out.print(i + " ");
        }

        fileIS.close();
        reader.close();
    }
}
