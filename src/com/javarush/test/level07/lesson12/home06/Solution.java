package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их
так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human grFa1 = new Human("дедушка1", true, 66, null, null);
        Human grFa2 = new Human("дедушка2", true, 88, null, null);

        Human grMo1 = new Human("бабушка1", false, 55, null, null);
        Human grMo2 = new Human("бабушка2", false, 77, null, null);

        Human father = new Human("отец", true, 44, grFa1, grMo1);
        Human mother = new Human("мать", false, 33, grFa2, grMo2);

        Human child1 = new Human("ребенок1", true,  5, father, mother);
        Human child2 = new Human("ребенок2", false, 3, father, mother);
        Human child3 = new Human("ребенок3", false, 0, father, mother);

        System.out.println(grFa1);
        System.out.println(grFa2);
        System.out.println(grMo1);
        System.out.println(grMo2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);





    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

    }

}
