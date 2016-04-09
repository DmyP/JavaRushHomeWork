package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(new File(bufferedReader.readLine()));
        bufferedReader.close();
        int min = -1;
        int tmp;
        while(inputStream.available() > 0){
            if (min == -1) min = inputStream.read();
            tmp = inputStream.read();
            if(tmp < min){
                min = tmp;
            }
        }
        System.out.println(min);
        inputStream.close();
    }
}
