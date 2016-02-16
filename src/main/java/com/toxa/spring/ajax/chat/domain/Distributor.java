package com.toxa.spring.ajax.chat.domain;

public class Distributor/* extends Thread*/{

    private Messages msg = Messages.getInstance();
//    private volatile boolean running = true;
    private Thr thr = new Thr();

//    @Override
//    public void run(){
//
//        while (true){
//            try {
//                System.out.println("wait...");
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }

//    public void pauseThread(){
//        running = false;
//    }
//
//    public void resumeThread(){
//        running = true;
//    }

    public String get(final int n){
        System.out.println(msg.getMessageNumber() + " || " + n);
        if(msg.getMessageNumber() > n){
            System.out.println("<>");
            return msg.get(n).toString();
        }
        else{

//            final Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//
//                        for(int i = 0; i < 6; i++){
//                            System.out.println("i... " + i);
//                            Thread.sleep(1000);
//                        }
//                        while (true){
//                            System.out.println("wait..........");
//                           thr.run();
//                        }
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("!!!!!!!!!!!!!!!!");
//                }
//            });

            synchronized (thr){
                try {
                    thr.start();

                    thr.wait();

                    thr.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("go go");
            return msg.get(n).toString();
        }
    }
}
