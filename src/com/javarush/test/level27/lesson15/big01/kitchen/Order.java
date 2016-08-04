package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

public class Order
{
    protected List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet ) throws IOException
    {
        this.tablet = tablet;
        initDishes();
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public int getTotalCookingTime(){
        int summ = 0;
        for (int i = 0; i < dishes.size(); i++)
        {
            summ+=dishes.get(i).getDuration();
        }
        return summ;
    }

    @Override
    public String toString()
    {
        Formatter format = new Formatter();
        return dishes.isEmpty() ? "" : format.format("Your order: %s of " + tablet.toString(), Arrays.toString(dishes.toArray())).toString();
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }

    protected void initDishes() throws IOException
    {
        dishes = new ArrayList<>();
        dishes.addAll(ConsoleHelper.getAllDishesForOrder());
    }

    public Tablet getTablet()
    {
        return tablet;
    }
}