package com.javarush.test.level08.lesson08.task03;

import java.util.*;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<>();
            map.put("фамилия1", "имя1");
            map.put("фамилия2", "имя2");
            map.put("фамилия3", "имя3");
            map.put("фамилия4", "имя4");
            map.put("фамилия5", "имя5");
            map.put("фамилия6", "имя6");
            map.put("фамилия7", "имя7");
            map.put("фамилия8", "имя8");
            map.put("фамилия9", "имя9");
            map.put("фамилия10", "имя1");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        Collection<String> values = map.values();
        for(String str: values){
            if (str.equals(name)) count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        if (map.containsKey(lastName)) return 1;
        else return 0;
    }

}
