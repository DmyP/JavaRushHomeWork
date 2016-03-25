package com.javarush.test.level04.lesson04.task02;

import static java.lang.Math.abs;

/*
Реализовать метод closeToTen.
Метод должен выводить на экран ближайшее к 10 из двух чисел, записанных в аргументах метода.Например, среди чисел 8 и 11 ближайшее к десяти 11.
Если оба числа на равной длине к 10, то вывести на экран любое из них.
 */
public class Solution {
    public static void main(String[] args) {
        closeToTen(14, 7);
    }
    public static void closeToTen (int x, int y) {
        int k = abs(10-x);
        int k2 = abs(10-y);

        if (k < k2) System.out.println(k);
        else if (k >= k2) System.out.println(k2);

    }

}
