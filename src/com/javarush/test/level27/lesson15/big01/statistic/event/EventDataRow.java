package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

public interface EventDataRow
{
    Date getDate();
    EventType getType();
    int getTime();
}

