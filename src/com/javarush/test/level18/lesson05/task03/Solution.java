package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int length, half;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream1 = new FileInputStream(reader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());

        length = inputStream1.available();
        half = length / 2;
        byte[] buffer1 = new byte[length - half];
        byte[] buffer2 = new byte[half];

        int count1 = inputStream1.read(buffer1);
        outputStream1.write(buffer1, 0, count1);
        int count2 = inputStream1.read(buffer2);
        outputStream2.write(buffer2, 0, count2);

        reader.close();
        inputStream1.close();
        outputStream1.close();
        outputStream2.close();

    }
}
