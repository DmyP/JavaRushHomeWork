package com.javarush.test.level37.lesson04.big01.female;

import com.javarush.test.level37.lesson04.big01.Human;

public class KidGirl implements Human {
    public static int MAX_AGE = 12;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{}";
    }
}
