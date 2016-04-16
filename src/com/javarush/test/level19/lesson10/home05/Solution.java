package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));

        while (bufferedReader.ready()) {
            String result = "";
            String string = bufferedReader.readLine();
            String[] strings = string.split(" ");
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].matches(".*\\d.*")) result = result.concat(strings[i] + " ");
            }
            bufferedWriter.write(result);
        }
    bufferedReader.close();
        bufferedWriter.close();
    }
}
