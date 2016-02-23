package com.toxa.spring.ajax.chat.domain;

import java.util.ArrayList;

public class Messages {

    private static Messages msg;
    private ArrayList<Message> msgList = new ArrayList<Message>();
    private ArrayList<Thread> msgAwaitingList = new ArrayList<Thread>();
    private ArrayList<String> usersList = new ArrayList<String>();
    private boolean changeUsers = false;

    private Messages(){
    }

    public static synchronized Messages getInstance(){
        if(msg == null)
            msg = new Messages();
        return msg;
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

    public void notifyMsgList(){
        for(Thread thr : msgAwaitingList){
            synchronized (thr){
                thr.notifyAll();
            }
        }

        msgAwaitingList.clear();
    }

    public void addMsgAwaitingList(Thread thr) {
        msgAwaitingList.add(thr);
    }

    public ArrayList<String> getUsersList() {
        changeUsers = false;
        return usersList;
    }

    public void addUsersList(String user) {
        changeUsers = true;
        usersList.add(user);
        notifyMsgList();
    }

    public boolean isChangeUsers() {
        return changeUsers;
    }
}
