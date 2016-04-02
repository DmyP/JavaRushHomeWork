package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] arrayLists = new ArrayList[3];

        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList1.add("абвгдеёжзийклмнопрстуфхцчшщъыьэюя");
        arrayList2.add("абвгдеёжзийклмнопрстуфхцчшщъыьэюя");
        arrayList3.add("x");

        arrayLists[0] = arrayList1;
        arrayLists[1] = arrayList2;
        arrayLists[2] = arrayList3;


        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}