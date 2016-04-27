package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private LinkedBlockingQueue<Order> queue;
    final static Logger logger = Logger.getLogger(Tablet.class.getName());
    private final int number;

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            if (!order.isEmpty()) {
                ConsoleHelper.writeMessage(order.toString());
                setChanged();
                notifyObservers(order);
            }

            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }


    public void createTestOrder() {
        TestOrder testOrder = null;
        try
        {
            testOrder = new TestOrder(this);
            ConsoleHelper.writeMessage(testOrder.toString());
            if(!testOrder.isEmpty())
            {
                try {
                    queue.put(testOrder);
                } catch (InterruptedException e) {
                }
                AdvertisementManager advertisementManager = new AdvertisementManager(testOrder.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
            }
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO,"No video is available for the order " + testOrder);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
    }
}