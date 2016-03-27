package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name;
    private int heigh;
    private String color;

    public Dog(String name){
        this.name = name;
        this.heigh = 1;
        this.color = "x";
    }

    public Dog(String name, int heigh, String color){
        this.name = name;
        this.heigh = heigh;
        this.color = color;
    }

    public Dog(String name, int heigh) {
        this.name = name;
        this.heigh = heigh;
        this.color = "x";
    }

}
