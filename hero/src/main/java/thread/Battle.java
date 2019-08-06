package main.java.thread;

import main.java.leagueOfLegends.charactor.Hero;

/*
 * 同为多线程接口，为什么Runnable更好
 * 1、首先来从接口实现和类继承的区别来谈谈，Thread是继承又因为Java是单继承，当已存在继承的情况下就无法在继承 Thread ，而Runnable则不受影响；
 * 2、从Thread和Runnable的实现机制再来谈谈这个问题，首先 Thread 和 Runnable 实际上是一种静态代理的实现方式。线程启动是调用 thread.start() 方法，
 * 		但是 start() 方法会调用 native 的 start0()方法，继而由 JVM 来实现多线程的控制,因为需要系统调用来控制时间分片。这种实现方式实际上是重写了 run() 方法，
 *		由于线程的资源和 Thread 实例捆绑在一起，所以不同的线程的资源不会进行共享。线程资源与 Runnable 实例捆绑在一起，Thread 只是作为一个代理类，
 *		所以资源可以进行共享。
*/
public class Battle implements Runnable{
     
    private Hero h1;
    private Hero h2;
 
    public Battle(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
 
    public void run(){
        while(!h2.isDead()){
        	int n = 0;
        	if(h2.name.equals("提莫"))
        		n = 2000;
        	else{
        		n = 1000;
        	}
            h1.attackHero(h2, n);
        }
    }
}
