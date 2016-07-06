package com.javarush.test.level34.lesson02.task03;

/* Разложение на множители с помощью рекурсии
Разложить целое число n > 1 на простые множители.
Вывести в консоль через пробел все множители в порядке возрастания.
Написать рекуррентный метод для вычисления простых множителей.
Не создавайте статические переменные и поля класса.
Пример:
132
Вывод на консоль:
2 2 3 11
*/
public class Solution {
    public void recursion(int n) {
        recursion(n, 2);
    }

    public void recursion(int n, int divisor) {
        if(n == 1) return;
        if(n % divisor != 0) {
            while(n % divisor != 0)
                ++divisor;
        }
        if(n % divisor == 0) {
            System.out.print(divisor + " ");
            recursion(n / divisor);
        }
    }

}
