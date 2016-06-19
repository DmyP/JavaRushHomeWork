package com.javarush.test.level30.lesson15.big01;

import java.io.Serializable;

public class Message implements Serializable {
    private final MessageType type;
    private final String data;

    public Message(MessageType type) {
        this.data = null;
        this.type = type;
    }

    public Message(MessageType type, String data) {
        this.data = data;
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public MessageType getType() {
        return type;
    }
}
