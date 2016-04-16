package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        int count = 0;
        while (fileReader.ready())
        {
            String[] str = fileReader.readLine().split("[., !?;:-]");
            for (String s : str) {
                if ("world".equals(s)) count++;
            }
        }
        System.out.println(count);
        bufferedReader.close();
        fileReader.close();
    }
}
