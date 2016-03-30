package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone1", new Date("JUNE 1 1980"));
        map.put("Stallone2", new Date("JUNE 1 1980"));
        map.put("Stallone3", new Date("JANUARY 1 1980"));
        map.put("Stallone4", new Date("FEBRUARY 1 1980"));
        map.put("Stallone5", new Date("MARCH 1 1980"));
        map.put("Stallone6", new Date("APRIL 1 1980"));
        map.put("Stallone7", new Date("MAY 1 1980"));
        map.put("Stallone8", new Date("AUGUST 1 1980"));
        map.put("Stallone9", new Date("SEPTEMBER 1 1980"));
        map.put("Stallone10", new Date("DECEMBER 1 1980"));


        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Date date = new Date();
            Iterator<Map.Entry<String,Date>> iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String,Date> entry = iter.next();
                if ((entry.getValue().getMonth() > 4) && (entry.getValue().getMonth() < 8)) {
                    iter.remove();
                }
            }
    }
}
