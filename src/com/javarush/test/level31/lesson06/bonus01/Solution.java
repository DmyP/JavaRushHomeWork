package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        File resultFile = new File(args[0]);
        List<String> unsortedList = new ArrayList<>();
        List<FileInputStream> list = new ArrayList<>();

        for (int i = 1; i < args.length; i++){
            unsortedList.add(args[i]);
        }
        Collections.sort(unsortedList);
        try {
            for (int i = 0; i < unsortedList.size(); i++)
                list.add(new FileInputStream(unsortedList.get(i)));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(list)))) {
            for(ZipEntry entry = null; (entry = zipInputStream.getNextEntry()) != null; ) {
                OutputStream OutputStream = new BufferedOutputStream(new FileOutputStream(resultFile));
                final int bufferSize = 1024;
                byte[] buffer = new byte[bufferSize];
                for(int readBytes = -1; (readBytes = zipInputStream.read(buffer, 0, bufferSize)) > -1; ) {
                    OutputStream.write(buffer, 0, readBytes);
                }
                OutputStream.flush();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

