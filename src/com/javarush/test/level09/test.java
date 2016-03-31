package com.javarush.test.level09;

import java.io.UnsupportedEncodingException;

public class test {
    public static void main(String[] args) {
        String str3 = "20150";
        byte[] b3 = str3.getBytes();
        System.out.println(b3);

        try {
            String s = new String(b3, "cp1251");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
