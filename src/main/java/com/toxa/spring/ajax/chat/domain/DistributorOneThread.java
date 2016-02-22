package com.toxa.spring.ajax.chat.domain;

public class DistributorOneThread {

    private Messages msg = Messages.getInstance();

    public String get(final int n){
        System.out.println(msg.getMessageNumber() + " || " + n);
        if(msg.getMessageNumber() > n){
            System.out.println("<>");
            return msg.get(n).toString();
        }
        else{
            while (msg.getMessageNumber() < n){
                Thread.yield();
            }

            return msg.get(n).toString();
        }
    }
}
