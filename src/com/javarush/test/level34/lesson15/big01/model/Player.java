package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable{
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        int upperLeftX = getX() - getWidth() / 2;
        int upperLeftY = getY() - getHeight() / 2;
        graphics.drawOval(upperLeftX, upperLeftY, getWidth(), getHeight());
        graphics.fillOval(upperLeftX, upperLeftY, getWidth(), getHeight());
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(getX() - getWidth() / 3, getY() - getWidth() / 3, getWidth()/3, getHeight()/3);
        graphics.fillOval(getX() + getWidth() / 10, getY() - getWidth() / 3, getWidth()/3, getHeight()/3);
        graphics.setColor(Color.RED);
        graphics.fillOval(getX() - getWidth() / 4, getY() + getWidth() / 10, getWidth()/2, getHeight()/4);
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
