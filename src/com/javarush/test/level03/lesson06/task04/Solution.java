package com.javarush.test.level03.lesson06.task04;

/* Экранирование символов
Про экранирование символов в Java читайте в дополнительном материале к лекции.
Вывести на экран следующий текст - две строки:

It's Windows path: "C:\Program Files\Java\jdk1.7.0\bin"
It's Java string: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "It's Windows path: " + "\"" + "C:"+ "\\" + "Program Files" +"\\" + "Java" + "\\" + "jdk1.7.0" + "\\"+  "bin" + "\"";
        System.out.println(s);
        s = s.replaceAll("Windows path","Java string");
        s = s.replaceAll("\\\\","\\\\\\\\");
        s = s.replaceAll("\"","\\\\\"");
        System.out.println(s);
    }
}