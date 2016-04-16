package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.readLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.readLine()));
        while (bufferedReader.ready()) {
            String string = bufferedReader.readLine().replaceAll("[.]", "!");
            bufferedWriter.write(string);
        }
        file.close();
        bufferedReader.close();
        bufferedWriter.close();
    }

}
