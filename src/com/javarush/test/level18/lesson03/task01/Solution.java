package com.javarush.test.level18.lesson03.task01;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(new File(bufferedReader.readLine()));
        bufferedReader.close();
        int max = 0;
        int tmp;

        while(inputStream.available() > 0){
            tmp = inputStream.read();
            if(tmp > max){
                max = tmp;
            }
        }

        System.out.println(max);
        inputStream.close();
    }
}

