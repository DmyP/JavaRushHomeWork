package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {

        int counterWords = 0;
        int counterNumbers = 0;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                counterNumbers++;
            } else counterWords++;
        }

        String[] words = new String[counterWords];
        String[] numbers = new String[counterNumbers];

        counterWords = 0;
        counterNumbers = 0;

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                numbers[counterNumbers] = array[i];
                counterNumbers++;
            } else {
                words[counterWords] = array[i];
                counterWords++;
            }
        }

        String temp;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length - i; j++) {
                int a = Integer.parseInt(numbers[j - 1]);
                int b = Integer.parseInt(numbers[j]);
                if (a < b) {
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length - 1; j++) {
                if (isGreaterThan(words[j], words[j + 1])) {
                    temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }

        counterWords = 0;
        counterNumbers = 0;

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = numbers[counterNumbers];
                counterNumbers++;
            } else {
                array[i] = words[counterWords];
                counterWords++;
            }
        }
    }






    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
