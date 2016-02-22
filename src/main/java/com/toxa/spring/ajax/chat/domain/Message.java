package com.toxa.spring.ajax.chat.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private String author;
    private String message;
    private Date time;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
        time = new Date();
    }

    @Override
    public String toString(){
        return "[" + author + " " + dateFormat.format(time) + "]: " + message;
    }
}
