package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Home extends GameObject{


    public Home(int x, int y) {
        super(x, y);
        setWidth(2);
        setHeight(2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        int upperLeftX = getX() - getWidth() / 2;
        int upperLeftY = getY() - getHeight() / 2;
        graphics.drawRect(upperLeftX, upperLeftY, getWidth(), getHeight());
        graphics.fillRect(upperLeftX, upperLeftY, getWidth(), getHeight());
    }
}
