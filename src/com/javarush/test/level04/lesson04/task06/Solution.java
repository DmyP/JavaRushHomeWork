package com.javarush.test.level04.lesson04.task06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public Solution() {
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        if(n == 1) {
            System.out.println("понедельник");
        } else if(n == 2) {
            System.out.println("вторник");
        } else if(n == 3) {
            System.out.println("среда");
        } else if(n == 4) {
            System.out.println("четверг");
        } else if(n == 5) {
            System.out.println("пятница");
        } else if(n == 6) {
            System.out.println("суббота");
        } else if(n == 7) {
            System.out.println("воскресенье");
        } else {
            System.out.println("такого дня недели не существует");
        }

    }
}