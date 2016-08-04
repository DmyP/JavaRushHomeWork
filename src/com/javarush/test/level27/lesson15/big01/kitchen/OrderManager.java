package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    public LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public OrderManager() {

    }

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        try {
            queue.put(order);
        } catch (InterruptedException e) {
        }

    }
}