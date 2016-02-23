package com.toxa.spring.ajax.chat.domain.thread;

import com.toxa.spring.ajax.chat.domain.Messages;
import com.toxa.spring.ajax.chat.domain.SendingObject;

public class DistributorForThread {

    private Messages msg = Messages.getInstance();
    private Thr thr;

    public SendingObject getMsg(int n){

        if(msg.getMessageNumber() >= n)
            return new SendingObject(msg.get(n).toString(), null);
        else{
            thr = new Thr();
            thr.start();

            try {
                msg.addMsgAwaitingList(thr);
                thr.join();
            } catch (InterruptedException e) {
                thr.interrupt();
                e.printStackTrace();
            }
            if(msg.isChangeUsers())
                return new SendingObject(null, msg.getUsersList());
            else
                return new SendingObject(msg.get(n).toString(), null);


        }

    }

}
