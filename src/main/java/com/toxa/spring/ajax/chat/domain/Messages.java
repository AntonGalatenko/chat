package com.toxa.spring.ajax.chat.domain;

import java.util.ArrayList;

public class Messages {

    private static Messages msg;
    private ArrayList<Message> msgList = new ArrayList<Message>();
//    private int n = 0;

    private Messages(){
    }

    public static synchronized Messages getInstance(){
        if(msg == null)
            msg = new Messages();
        return msg;
    }

    public ArrayList<Message> get() {
        return msgList;
    }

    public Message get(int n){
        ArrayList<Message> result = new ArrayList<Message>();
//        result.addAll(msgList.subList(--n, msgList.size()));
//                (ArrayList<Message>) msgList.subList(n, msgList.size());
        return msgList.get(--n);
    }

    public void add(Message message) {
//        n++;
//        new Distributor().notifyAll();
        msgList.add(message);
    }

    public int getMessageNumber(){
        return msgList.size();
    }
}
