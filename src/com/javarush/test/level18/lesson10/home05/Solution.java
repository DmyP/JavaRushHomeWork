package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());

        byte[] buffer = new byte[fileInputStream.available()];
        int readN = fileInputStream.read(buffer);
        String[] str = new String(buffer).split(" ");
        String res = "";
        for (int i = 0; i < str.length; i++) {
           res += Math.round(Double.valueOf(str[i])) + " ";
        }
        res = res.trim();
        byte[] buffer2 = res.getBytes();
        fileOutputStream.write(buffer2);

        reader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
