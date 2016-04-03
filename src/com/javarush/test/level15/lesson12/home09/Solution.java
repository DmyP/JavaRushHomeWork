package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        try {
            string = reader.readLine();
        } catch (IOException e) {
        }
        string = string.substring(string.indexOf("?")+1);
        String[] parts = string.split("&");
        String key = null;
        String value = null;
        String result = "";
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].contains("=")) {
                key = parts[i].substring(0, parts[i].indexOf("="));
                result = result + key + " ";
                if (key.equals("obj")) {
                    value = parts[i].substring(parts[i].indexOf("=") + 1, parts[i].length());
                }
            } else result = result + parts[i] + " ";
        }
        System.out.println(result);
        if (value != null){
            try {
                alert(Double.parseDouble(value));
            }catch (Exception ex){
                alert(value);
            }

        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
