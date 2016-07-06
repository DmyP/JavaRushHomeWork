package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);
        int upperLeftX = getX() - getWidth() / 2;
        int upperLeftY = getY() - getHeight() / 2;
        graphics.drawRect(upperLeftX, upperLeftY, getWidth(), getHeight());
        graphics.fillRect(upperLeftX, upperLeftY, getWidth(), getHeight());
    }
}
