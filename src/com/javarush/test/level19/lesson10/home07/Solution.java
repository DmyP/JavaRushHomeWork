package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =  new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
            String result = "";

        while (bufferedReader.ready()) {
            String string = bufferedReader.readLine();
            String[] strings = string.split(" ");
            for (int i = 0; i < strings.length; i++) {

                if (strings[i].length() > 6) {
                    if (result.length() > 0) {
                        result += ",";
                    }
                    result = result.concat(strings[i]);
                }
            }

            }
        bufferedWriter.write(result);
        bufferedReader.close();
        bufferedWriter.close();

    }
}
