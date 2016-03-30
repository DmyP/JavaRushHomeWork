package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        Map<String, String> map = new HashMap<>();
        map.put("фамилия0", "имя1");
        map.put("фамилия0", "имя2");
        map.put("фамилия3", "имя0");
        map.put("фамилия4", "имя0");
        map.put("фамилия5", "имя0");
        map.put("фамилия6", "имя6");
        map.put("фамилия7", "имя7");
        map.put("фамилия8", "имя8");
        map.put("фамилия9", "имя9");
        map.put("фамилия10", "имя10");
        return map;

    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
