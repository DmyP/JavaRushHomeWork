package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

public class NoAvailableVideoEventDataRow implements EventDataRow{

    int totalDuration;
    Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }
}
