package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(0.0, "A");
        labels.put(1.1, "B");
        labels.put(5.5, "C");
        labels.put(10.1, "D");
        labels.put(99.99, "E");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
