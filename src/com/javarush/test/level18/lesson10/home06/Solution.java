package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);

        int[] counts = new int[256];
        for (int i = 0; i < buffer.length; ++i) {
            counts[buffer[i]]++;
        }
        for (int j = 0; j < counts.length; j++) {
            if (counts[j] != 0) System.out.println((char) j + " " + counts[j]);
        }

        fileInputStream.close();
        reader.close();
    }
}
