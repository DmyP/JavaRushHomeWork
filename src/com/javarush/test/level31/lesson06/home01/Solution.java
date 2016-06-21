package com.javarush.test.level31.lesson06.home01;

import java.io.*;
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
public class Solution {
    public static Map<ZipEntry, byte[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        File fileToAdd = new File(args[0]);
        File archive = new File(args[1]);

        readArchive(archive);
        writeArchive(archive, fileToAdd);
    }

    private static void readArchive(File archive) {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archive))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutStream = new ByteArrayOutputStream();
                byte[] bytesBuffer = new byte[1024];
                int numReadBytes;
                while ((numReadBytes = zipInputStream.read(bytesBuffer)) != -1) {
                    byteArrayOutStream.write(bytesBuffer, 0, numReadBytes);
                }
                map.put(entry, byteArrayOutStream.toByteArray());
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    private static void writeArchive(File archive, File fileToAdd) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(archive))) {
            for (Map.Entry<ZipEntry, byte[]> zipEntry : map.entrySet()) {
                if (zipEntry.getKey().getName().endsWith(fileToAdd.getName())) {
                    continue;
                }
                zipOutputStream.putNextEntry(zipEntry.getKey());
                zipOutputStream.write(zipEntry.getValue());
                zipOutputStream.closeEntry();
            }

            FileInputStream fileInputStream = new FileInputStream(fileToAdd);
            byte[] fileBytes = new byte[fileInputStream.available()];
            fileInputStream.read(fileBytes);
            fileInputStream.close();

            ZipEntry zipEntry = new ZipEntry("new/" + fileToAdd.getName());
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(fileBytes);
            zipOutputStream.closeEntry();
            zipOutputStream.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
}
