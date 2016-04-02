package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String firstName;
        String secondName;
        boolean sex;
        int age;
        int heigt;
        String adress;

        public Human(String firstName, String secondName, boolean sex, int age, int heigt, String adress) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.sex = sex;
            this.age = age;
            this.heigt = heigt;
            this.adress = adress;
        }

        public Human(String firstName, String secondName, boolean sex, int age, int heigt) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.sex = sex;
            this.age = age;
            this.heigt = heigt;
            this.adress = "";
        }

        public Human(String firstName, String secondName, boolean sex, int age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.sex = sex;
            this.age = age;
            this.heigt = 0;
            this.adress = "";
        }

        public Human(String firstName, String secondName, boolean sex) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.sex = sex;
            this.age = 0;
            this.heigt = 0;
            this.adress = "";
        }

        public Human(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.sex = false;
            this.age = 0;
            this.heigt = 0;
            this.adress = "";
        }

        public Human(String firstName, boolean sex, int age, int heigt, String adress) {
            this.firstName = firstName;
            this.secondName = "";
            this.sex = sex;
            this.age = age;
            this.heigt = heigt;
            this.adress = adress;
        }

        public Human(String firstName, boolean sex, int age, int heigt) {
            this.firstName = firstName;
            this.secondName = "";
            this.sex = sex;
            this.age = age;
            this.heigt = heigt;
            this.adress = "";
        }

        public Human(String firstName, boolean sex, int age) {
            this.firstName = firstName;
            this.secondName = "";
            this.sex = sex;
            this.age = age;
            this.heigt = 0;
            this.adress = "";
        }

        public Human(String firstName, boolean sex) {
            this.firstName = firstName;
            this.secondName = "";
            this.sex = sex;
            this.age = 0;
            this.heigt = 0;
            this.adress = "";
        }

        public Human(String firstName) {
            this.firstName = firstName;
            this.secondName = "";
            this.sex = false;
            this.age = 0;
            this.heigt = 0;
            this.adress = "";
        }
    }
}
