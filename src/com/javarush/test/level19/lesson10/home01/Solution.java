package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String,Double> names = new TreeMap<>();
       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), Charset.forName("windows-1251")));
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string;
        String[] strings;
        while ((string = bufferedReader.readLine()) != null) {
            strings = string.split(" ");
            if (!names.containsKey(strings[0])) {
                names.put(strings[0], Double.parseDouble(strings[1]));
            } else {
                names.put(strings[0], names.get(strings[0]) + Double.parseDouble(strings[1]));
            }
        }
        for (String key : names.keySet()) {
            System.out.println(key + " " + names.get(key));
        }

        bufferedReader.close();
        fileReader.close();
    }
}
