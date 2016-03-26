package test;

public class test2 {
    public static void main(String[] args) {
String s = "%one%%two%%%three%%%%";
        String[] s1 = s.split("[one,two,three]");
        System.out.println(s1);


    }
 }