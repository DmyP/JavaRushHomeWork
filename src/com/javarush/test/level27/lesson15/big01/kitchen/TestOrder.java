package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        Dish[] allDishes = Dish.values();
        List<Dish> differentDishes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int numb = (int) (Math.random() * allDishes.length);
            differentDishes.add(allDishes[numb]);
        }
        dishes = differentDishes;
    }
}