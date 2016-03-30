package com.javarush.test.level08.lesson11.home09;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное
число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

import java.util.Calendar;
import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {
        String dateStr = "JANUARY 2 2020";
        boolean flag;
        flag = isDateOdd(dateStr);
        System.out.println(dateStr + " = " + flag);
    }

    public static boolean isDateOdd(String date)
    {
        Date d = new Date(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);

        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        if (dayOfYear % 2 == 0) return false;
        else return true;
    }
}
