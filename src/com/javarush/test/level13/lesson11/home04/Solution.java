package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException {

        String s = "";
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(bufferedReader.readLine()))));

        while (!s.equals("exit"))
        {
            s = bufferedReader.readLine();
            bufferedWriter.write(s);
            bufferedWriter.newLine();

        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
