package com.wz.state;

public class TestStop implements Runnable{

    //设置一个标识位
    private boolean flag=true;

    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("run.....Thread"+i++);
        }
    }

    //设置一个公开的方法停止线程
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {

        TestStop testStop=new TestStop();

        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if(i==900){
                testStop.stop();
                System.out.println("线程停止了");
            }
        }

    }
}
