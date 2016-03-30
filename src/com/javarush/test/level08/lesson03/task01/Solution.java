package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        HashSet<String> mySet = new HashSet<String>();
        mySet.add("арбуз");
        mySet.add("банан");
        mySet.add("вишня");
        mySet.add("груша");
        mySet.add("дыня");
        mySet.add("ежевика");
        mySet.add("жень-шень");
        mySet.add("земляника");
        mySet.add("ирис");
        mySet.add("картофель");

        for (String text : mySet)
        {
            System.out.println(text);
        }

    }
}
