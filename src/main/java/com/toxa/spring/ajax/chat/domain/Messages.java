package com.toxa.spring.ajax.chat.domain;

import java.util.ArrayList;
import java.util.List;

public class Messages {

    private static Messages msg;
    private List<Thread> thrList = new ArrayList<Thread>();
    private ArrayList<Message> msgList = new ArrayList<Message>();

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
        return msgList.get(--n);
    }

    public void add(Message message) {
        msgList.add(message);
        notifyMsgList();
    }

    public int getMessageNumber(){
        return msgList.size();
    }

    public void addThrList(Thread thr) {
        thrList.add(thr);
    }

    public void notifyMsgList(){
        for(Thread thr: thrList){
            synchronized (thr){
                thr.notifyAll();
            }
        }

        thrList.clear();
    }
}
