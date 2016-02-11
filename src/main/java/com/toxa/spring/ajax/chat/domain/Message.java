package com.toxa.spring.ajax.chat.domain;

public class Message {

    private String author;
    private String message;
//    private Date time;

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
    }

    @Override
    public String toString(){
        return "[" + author + "]: " + message;
    }
}
