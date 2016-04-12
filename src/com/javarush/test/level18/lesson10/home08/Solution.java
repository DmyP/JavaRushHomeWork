package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> fileNames = new ArrayList<>();
        String fileName;
        while(!(fileName = reader.readLine()).equals("exit")){
            fileNames.add(fileName);
            new ReadThread(fileName).start();
        }
        reader.close();
        Thread.sleep(1000);
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            int[] bytes = new int[256];
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                int maxNum = 0;
                int maxVal = 0;
                while (fileInputStream.available() > 0){
                    int i = fileInputStream.read();
                    bytes[i]++;
                    for (int j = 0; j < bytes.length; j++) {
                        if (bytes[j] > maxVal) {
                            maxVal = bytes[j];
                            maxNum = j;
                        }
                    }
                }
                fileInputStream.close();
                synchronized (resultMap) {
                    resultMap.put(fileName, maxNum);
                }
            } catch (Exception e) {
            }
        }
    }
}
