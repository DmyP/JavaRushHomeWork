package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.readLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.readLine()));
        String[] strings;
        while (bufferedReader.ready()) {
            String string = "";
            strings = bufferedReader.readLine().split(" ");
            for (int i = 0; i < strings.length; i++) {
                if (isNumeric(strings[i])) string += (strings[i] + " ");
            }
            bufferedWriter.write(string.trim());
        }
        file.close();
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static boolean isNumeric(String str)
    {
        try {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
