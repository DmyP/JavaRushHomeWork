package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet();

        for (String string : strings) {
            result.add(shortener.getId(string));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet();

        for (Long  key : keys) {
            result.add(shortener.getString(key));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set stringsSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)    {
            stringsSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Long timeForId;
        Long timeForString;
        Date begin = new Date();
        Set<Long> createdIds = getIds(shortener, stringsSet);
        Date end = new Date();
        timeForId = end.getTime() - begin.getTime();
        Helper.printMessage(Long.toString(timeForId));

        begin = new Date();
        Set<String> createdStrings = getStrings(shortener, createdIds);
        end = new Date();
        timeForString = end.getTime() - begin.getTime();
        Helper.printMessage(Long.toString(timeForString));


        if (createdStrings.equals(stringsSet))  {
            Helper.printMessage("Тест пройден.");
        } else  {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args)
    {
        testStrategy(new HashMapStorageStrategy(), 10000L);
        testStrategy(new OurHashMapStorageStrategy(), 10000L);
        testStrategy(new FileStorageStrategy(), 1L);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000L);
        testStrategy(new HashBiMapStorageStrategy(), 10000L);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000L);
    }
}
