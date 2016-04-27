package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger counter = new AtomicInteger(1);

    private void setPriority(){
        if (counter.get() > 10) counter.set(1);
        setPriority(counter.getAndIncrement());
    }
    private void setPriority(ThreadGroup threadGroup){
        if (counter.get() > 10) counter.set(1);
        setPriority((threadGroup.getMaxPriority() < counter.get()) ? threadGroup.getMaxPriority() : counter.get());
        counter.getAndIncrement();
    }


    public MyThread() {
        setPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority(group);
    }

    public MyThread(String name) {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority(group);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority(group);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority(group);
    }
}
