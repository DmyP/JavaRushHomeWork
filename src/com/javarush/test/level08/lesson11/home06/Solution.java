package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human child1 = new Human("child1", false, 1, null );
        Human child2 = new Human("child2", false, 3, null );
        Human child3 = new Human("child3", true, 5, null );

        ArrayList<Human> childrens = new ArrayList<>();
        childrens.add(child1);
        childrens.add(child2);
        childrens.add(child3);

        Human father = new Human("father", true, 35, childrens);
        Human mother = new Human("mother", false, 30, childrens);

        ArrayList<Human> fatherArray = new ArrayList<>();
        fatherArray.add(father);


        Human grFather1 = new Human("grFather1", true, 75, fatherArray);
        Human grMother1 = new Human("grMother1", false, 70, fatherArray);

        ArrayList<Human> motherArray = new ArrayList<>();
        motherArray.add(mother);

        Human grFather2 = new Human("grFather2", true, 65, motherArray);
        Human grMother2 = new Human("grMother2", false, 60, motherArray);

        System.out.println(grFather1);
        System.out.println(grFather2);
        System.out.println(grMother1);
        System.out.println(grMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            try {
                int childCount = this.children.size();
                if (childCount > 0)
                {
                    text += ", дети: "+this.children.get(0).name;

                    for (int i = 1; i < childCount; i++)
                    {
                        Human child = this.children.get(i);
                        text += ", "+child.name;
                    }
                }
            } catch (NullPointerException e) {
            }

            return text;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
    }

}
