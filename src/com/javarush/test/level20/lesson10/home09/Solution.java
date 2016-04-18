package com.javarush.test.level20.lesson10.home09;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable{
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        sol.node = 1;
        Solution sol2 = new Solution();
        sol2.node = 2;
        Solution sol3 = new Solution();
        sol3.node = 3;
        sol.edges.add(sol2);
        sol.edges.add(sol3);
        sol.edges.add(sol);
        sol.edges.add(sol2);
        sol.edges.add(sol);

        String fileName = "/Users/inna/Documents/1.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(sol);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Solution loadedS = (Solution)ois.readObject();
        ois.close();

        System.out.println("original:");
        System.out.println(sol.node);
        for (Solution s : sol.edges) System.out.print(s.node + " ");

        System.out.println("\nloaded:");
        System.out.println(loadedS.node);
        for (Solution s : loadedS.edges) System.out.print(s.node + " ");
    }
}
