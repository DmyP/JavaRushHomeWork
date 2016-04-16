package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String,Double> names = new TreeMap<>();
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string;
        String[] strings;
        while ((string = bufferedReader.readLine()) != null) {
            strings = string.split(" ");
            if (!names.containsKey(strings[0])) {
                names.put(strings[0], Double.parseDouble(strings[1]));
            } else {
                names.put(strings[0], names.get(strings[0]).doubleValue() + Double.parseDouble(strings[1]));
            }
        }
        double max = -1;
        String maxName = "";
        for (String key : names.keySet()) {
            if (max == -1 || names.get(key) > max) {
                max = names.get(key);
                maxName = key;

            }
            else if (names.get(key) == max) {
                maxName += " " + key;
            }

        }
        System.out.println(maxName);

        bufferedReader.close();
        fileReader.close();

    }
}