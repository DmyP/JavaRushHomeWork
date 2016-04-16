package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
new String(char[] cbuf, off, len)
/Users/inna/Documents/2.txt"
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileConsoleWriter extends FileWriter{

    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("/Users/inna/Documents/3.txt");
        fileConsoleWriter.write("Проверка String:");
        fileConsoleWriter.write(1234);
        char[] buff = "Проверка char buff:".toCharArray();
        fileConsoleWriter.write(buff);
        fileConsoleWriter.write(buff, 3, 5);
        fileConsoleWriter.write("Проверка String обрезка:", 0, 1);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
    }

    @Override
    public void write(int c) throws IOException {
        write(new char[] { (char)c }, 0, 1);
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        write(cbuf, 0, cbuf.length);
    }

    @Override
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        char[] cbuf = new char[len];
        str.getChars(off, (off + len), cbuf, 0);
        write(cbuf, 0, len);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        System.out.print(Arrays.copyOfRange(cbuf, off, off + len));
        super.write(cbuf, off, len);
    }
}
