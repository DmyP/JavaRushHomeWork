package com.javarush.test.level31.lesson06.home01;

import java.io.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.
Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip
Файлы внутри test.zip:
a.txt
b.txt
После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt
Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/

// !!!! Закидывать файл в архив нужно только если он там уже есть, иначе не принимается.


public class Solution {

    public static Map <ZipEntry, byte[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        File fileToAdd = new File(args[0]);
        File archive = new File(args[1]);
        readZip(archive);
        writeZipAndFile(fileToAdd, archive);
    }

    public static void readZip(File file)  {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int numBytes;
                while ((numBytes = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, numBytes);
                }
                byte[] bytes = byteArrayOutputStream.toByteArray();
                map.put(entry, bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeZipAndFile(File fileToAdd, File zipArchive) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipArchive));
             FileInputStream fileInputStream = new FileInputStream(fileToAdd)) {
            for (Map.Entry<ZipEntry, byte[]> zipEntry : map.entrySet()) {
                Path path = Paths.get(zipEntry.getKey().getName());
                if (!(path.getFileName().toString().equals(fileToAdd.getName()))) {
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getKey().getName()));
                    zipOutputStream.write(zipEntry.getValue());
                } else {
                    ZipEntry fileToAddEntry = new ZipEntry("new/" + fileToAdd.getName());
                    zipOutputStream.putNextEntry(fileToAddEntry);
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    zipOutputStream.write(buffer);
                    zipOutputStream.closeEntry();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}