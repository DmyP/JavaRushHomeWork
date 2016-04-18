package com.javarush.test.level20.lesson10.bonus01;

import java.util.LinkedList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        int n = 100_000_000;
        int[] numbers = getNumbers(n);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
    }

    public static int[] getNumbers(int N) {
        LinkedList<Integer> list = new LinkedList<>();
        int  a, n, c;
        for (int i = N; i > 0; i--) {

            int len = String.valueOf(i).length();
            n = i;
            c = 0;
            while (n > 0) {
                a = n % 10;
                n = n / 10;
                // c = (int) (c + Math.pow(a, len));
                if (len == 1) c = c + a;
                else if (len == 2) c = c + a * a;
                else if (len == 3) c = c + a * a * a;
                else if (len == 4) c = c + a * a * a * a;
                else if (len == 5) c = c + a * a * a * a * a;
                else if (len == 6) c = c + a * a * a * a * a * a;
                else if (len == 7) c = c + a * a * a * a * a * a * a;
                else if (len == 8) c = c + a * a * a * a * a * a * a * a;
                else if (len == 9) c = c + a * a * a * a * a * a * a * a * a;
                else if (len == 10) c = c + a * a * a * a * a * a * a * a * a * a;
                else if (len == 11) c = c + a * a * a * a * a * a * a * a * a * a * a;
            }
            if (i == c) list.add(0, c);
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
