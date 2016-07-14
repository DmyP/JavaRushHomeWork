package com.javarush.test.level36.lesson08.task01;

import com.google.common.primitives.Chars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        SortedSet<Character> treeSet = getTreeSet(args[0]);
        printFirstN(treeSet, 5);
    }

    private static SortedSet<Character> getTreeSet(String arg) throws IOException {
        SortedSet<Character> treeSet = new TreeSet();
        char[] chars = getString(arg).toLowerCase().toCharArray();
        for (char ch : chars) {
            if ((ch >= 'a' && ch <= 'z')) {
                treeSet.add(ch);
            }
        }
        return treeSet;
    }

    private static void printFirstN(SortedSet<Character> treeSet, int num) {
        int count = 0;
        for (char ch : treeSet) {
            if (count >= num) break;
            System.out.print(ch);
            count++;
        }
    }

    private static String getString(String arg) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arg));
        String resultString = "";
        while (reader.ready()) {
            resultString = resultString + reader.readLine();
        }
        return resultString;
    }
}
