package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public int min(int i, int i2){
        if (i < i2) return i;
        else return i2;
    }
    public long min(long i, long i2){
        if (i < i2) return i;
        else return i2;
    }
    public double min(double i, double i2){
        if (i < i2) return i;
        else return i2;
    }
}
