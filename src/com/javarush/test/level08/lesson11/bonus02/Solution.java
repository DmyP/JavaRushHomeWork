package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        HashMap<String,String> map = new HashMap<String, String>();
        while (true){
            String s1 = reader.readLine();
        if (s1.isEmpty()) break;
        else {
            String s2 = reader.readLine();
            map.put(s1,s2);
        }
    }

        //read home number
        String city = reader.readLine();
        String family = map.get(city);
        System.out.println(family);
    }
}
