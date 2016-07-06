package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        int upperLeftX = getX() - getWidth() / 2;
        int upperLeftY = getY() - getHeight() / 2;

        graphics.drawRect(upperLeftX, upperLeftY, getWidth(), getHeight());
        graphics.fillRect(upperLeftX, upperLeftY, getWidth(), getHeight());
        graphics.setColor(Color.BLACK);
        graphics.drawLine(upperLeftX, upperLeftY, getX() + getWidth() / 2,  getY() + getHeight() / 2);
        graphics.drawLine(upperLeftX , upperLeftY + Model.FIELD_SELL_SIZE, upperLeftX + Model.FIELD_SELL_SIZE, upperLeftY);
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
