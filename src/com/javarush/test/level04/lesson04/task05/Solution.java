package com.javarush.test.level04.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public Solution() {
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        if(n < 0) {
            ++n;
        } else {
            n *= 2;
        }

        System.out.println(n);
    }
}