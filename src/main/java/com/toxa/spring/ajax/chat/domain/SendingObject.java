package com.toxa.spring.ajax.chat.domain;

import java.util.ArrayList;

public class SendingObject {

    private String msg;
    private ArrayList<String> users = new ArrayList<String>();

    public SendingObject(String msg, ArrayList<String> users) {
        this.msg = msg;
        this.users = users;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }
}
