package com.wz.state;

public class TestSleep implements Runnable{

    private int ticketNum=10;

    @Override
    public void run() {
        while (true){
            if(ticketNum<=0){
                break;
            }
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到第"+ticketNum);
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep=new TestSleep();

        new Thread(testSleep,"小红").start();
        new Thread(testSleep,"小明").start();
        new Thread(testSleep,"小张").start();
    }
}
