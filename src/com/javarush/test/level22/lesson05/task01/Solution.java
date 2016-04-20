package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null)
            throw new TooShortStringException();
        int first = string.indexOf(" ");
        if (first == -1)
            throw new TooShortStringException();
        int last = first;
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            last = string.indexOf(" ", last + 1);
            if (last == -1)
                throw new TooShortStringException();
            counter ++;
        }
        char[] tailWord =  string.substring(last + 1).toCharArray();
        int index = 0;
        if (!Character.isLetter(tailWord[0]))
            throw new TooShortStringException();
        for (int i = 1; i < tailWord.length; i++)
        {
            if (Character.isLetter(tailWord[i]))
                index = i;
            else
                break;
        }
        return string.substring(first+1, last + index + 2);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main (String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
}