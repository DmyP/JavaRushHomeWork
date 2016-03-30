package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String, String> map =   createMap();
        removeTheFirstNameDuplicates(map);
        System.out.println(map);
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("фамилия1", "имя1");
        map.put("фамилия2", "имя1");
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
//работающая версия
//    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
//    {
//        int counter = 0;
//        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry<String, String> entry = iter.next();
//
//            Iterator<Map.Entry<String, String>> iter2 = map.entrySet().iterator();
//            while (iter2.hasNext()) {
//                try{
//                Map.Entry<String, String> entry2 = iter.next();
//
//                if ((entry.getValue()) == (entry2.getValue())) counter++;
//
//                }catch (Exception io){break;}
//            }
//            if (counter > 0) {
//                removeItemFromMapByValue(map, entry.getValue());
//            }
//            counter = 0;
//        }
//
//    }
//
//    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
//    {
//        Map<String, String> copy = new HashMap<String, String>(map);
//        for (Map.Entry<String, String> pair: copy.entrySet())
//        {
//            if (pair.getValue().equals(value))
//                map.remove(pair.getKey());
//        }
//    }

// версия которая прошла тест
    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashSet<String> list = new HashSet<String>();
        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();

        for(Map.Entry<String, String> s1 : map.entrySet()){
            int count = 0;
            for (Map.Entry<String, String> s2 : map.entrySet())
            {
                if (s1.getValue().equals(s2.getValue())) count++;
            }
            if(count > 1) list.add(iterator1.next().getKey());
        }
        for(String s : list){
            removeItemFromMapByValue(map,s);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        map.remove(value);
    }



}
