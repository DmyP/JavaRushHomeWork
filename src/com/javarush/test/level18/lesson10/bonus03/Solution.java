package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    static ArrayList<String> price = new ArrayList<String>();

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
        String string;
        while ((string = fileReader.readLine()) != null) {
            price.add(string);
        }
        int id = Integer.parseInt(args[1]);
        for (int i = 0; i < price.size(); i++) {
            if (id == Integer.parseInt(price.get(i).substring(0, 8).trim().replace(" ", ""))) {
                if ("-d".equals(args[0]))
                    price.remove(i);
                if ("-u".equals(args[0])) {
                    String str = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", args[1], args[2], args[3], args[4]);
                    price.add(i, str);
                    price.remove(i + 1);
                    break;
                }
            }
            }
        new FileWriter(fileName).close();

        for (String s: price){
            fileWriter.write(s);
            fileWriter.newLine();
            fileWriter.flush();
        }
        bufferedReader.close();
        fileReader.close();
        fileWriter.close();
    }
}
