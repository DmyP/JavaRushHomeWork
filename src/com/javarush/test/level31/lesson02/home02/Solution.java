package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.BlockingQueue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> files = getFileTree("d:/Downloads");
        assert files != null;
        for (String s : files) {
            System.out.println(s);
        }
    }

    public static List<String> getFileTree(String root) throws IOException {
        Stack<File> stack = new Stack<>();
        stack.push(new File(root));
        List<String> list = new ArrayList<>();

        while (!stack.empty()){
            File pop = stack.pop();
            if (!pop.isDirectory()) {
                list.add(pop.getAbsolutePath());
            } else {
                for (File file : pop.listFiles()){
                    stack.push(file);
                }
            }
        }
        return list;
    }
}
