package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        Map<String,Double> names = new TreeMap<>();
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string;
        String[] strings;
        while ((string = bufferedReader.readLine()) != null) {
            String name = "";
            strings = string.split(" ");
            int n = strings.length - 3;

            for (int i = 0; i < n; i++) name = name.concat(strings[i] + " ");
            name = name.trim();

            Date date = new Date(Integer.parseInt(strings[strings.length - 1]) - 1900, Integer.parseInt(strings[strings.length - 2]) - 1, Integer.parseInt(strings[strings.length - 3]));
            Person person = new Person(name, date);
            PEOPLE.add(person);

        }


        bufferedReader.close();
        fileReader.close();
    }

}
