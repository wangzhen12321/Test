package com.wz.state;


//测试生产消费问题2：信号灯法
public class TestPc2 {
    public static void main(String[] args) {
        Tv tv=new Tv();
        new Thread(new Player(tv)).start();
        new Thread(new Watcher(tv)).start();
    }


}

//生产者-->演员
class Player implements Runnable{
    Tv tv;
    public Player(Tv tv){
        this.tv=tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                this.tv.play("快乐大本营中");
            }else{
                this.tv.play("抖音");
            }
        }
    }
}


//消费者-->观众
class Watcher implements Runnable{
    Tv tv;
    public Watcher(Tv tv){
        this.tv=tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//产品-->节目
class Tv{
    String voice;//表演的节目
    boolean flag=true;
    //表演
    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了"+voice);
        //通知观众观看
        this.notifyAll();//通知唤醒
        this.voice=voice;
        this.flag=!this.flag;
    }

    //观看
    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("观看了:"+voice);
            //通知演员表演
            this.notifyAll();
            this.flag=!this.flag;
        }
    }
}
