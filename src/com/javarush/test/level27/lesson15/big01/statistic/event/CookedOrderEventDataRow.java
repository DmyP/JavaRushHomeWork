package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.util.Date;
import java.util.List;

public class CookedOrderEventDataRow implements EventDataRow{
    String tabletName;
    String cookName;
    int cookingTimeSeconds;
    List<Dish> cookingDishs;
    Date currentDate;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs)
    {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        this.currentDate = new Date();
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }

    @Override
    public int getTime() {
        return cookingTimeSeconds;
    }

    public String getCookName() {
        return cookName;
    }
}
