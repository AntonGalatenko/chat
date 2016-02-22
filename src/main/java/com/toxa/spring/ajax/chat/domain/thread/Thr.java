package com.toxa.spring.ajax.chat.domain.thread;

public class Thr extends Thread {

    @Override
    public void run(){

        try {
            synchronized (this){
                wait();
            }
        } catch (InterruptedException e) {
            interrupt();
            e.printStackTrace();
        }

    }

}
