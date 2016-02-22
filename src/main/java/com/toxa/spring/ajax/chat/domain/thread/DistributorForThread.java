package com.toxa.spring.ajax.chat.domain.thread;

import com.toxa.spring.ajax.chat.domain.Messages;

public class DistributorForThread {

    private Messages msg = Messages.getInstance();
    private Thr thr;

    public String get(int n){

        if(msg.getMessageNumber() >= n)
            return msg.get(n).toString();
        else{
            thr = new Thr();
            thr.start();

            try {
                msg.addThrList(thr);
                thr.join();
            } catch (InterruptedException e) {
                thr.interrupt();
                e.printStackTrace();
            }

            return msg.get(n).toString();
        }

    }

}
