package main.java.thread;

import main.java.util.Parents;

import java.util.Collections;
import java.util.LinkedList;

import main.java.leagueOfLegends.charactor.Hero;

/*
 * 练习-使用LinkedList实现Stack栈     顶 折 纠 问  Or    姿势不对,事倍功半! 点击查看做练习的正确姿势
 * 与FIFO(先入先出的)队列类似的一种数据结构是FILO先入后出栈Stack
 * 根据接口Stack ：
 * 实现类：MyStack
 * 
 * 练习-线程安全的MyStack
 * 把答案-使用LinkedList实现Stack栈 中的MyStack类，改造为线程安全的类。
*/
public class MyStack<T> extends Parents{
     public LinkedList<T> heros;
     
     public MyStack() {
		/*
		 * 练习-线程安全的MyStack
		 * 借助把非线程安全的集合转换为线程安全，用另一个方式完成 练习-线程安全的MyStack
		*/
    	 this.heros = (LinkedList<T>) Collections.synchronizedList(new LinkedList<T>());
     }
     
	 //把英雄推入到最后位置
    public synchronized void push(T h) {
    	heros.addFirst(h);
    };
    //把最后一个英雄取出来
    public synchronized T pull() {
    	return heros.pollFirst();
    };
    //查看最后一个英雄
    public synchronized T peek() {
    	return heros.peekFirst();
    };
    
    public static void main(String[] age) {
    	deadlock();
    }
    
	/*
	 * 练习-死锁
	 * 3个同步对象a, b, c
	 * 3个线程 t1,t2,t3
	 * 故意设计场景，使这3个线程彼此死锁
	*/
    private static void deadlock() {
    	Hero gareen = new Hero("盖伦",1000,100,100);
    	Hero timo = new Hero("提莫",1000,100,100);
    	Hero js = new Hero("剑圣",1000,100,100);
    	Runnable a = new Runnable() {
			public void run() {
				synchronized(gareen) {
					try {
						//停顿1000毫秒，另一个线程有足够的时间占有占用 对象
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
					synchronized(timo) {
						while(!timo.isDead()){
				        	gareen.attackHero(timo, 1000);
				        }
					}
				}
			}
    	};
    	Runnable b = new Runnable() {
    		public void run() {
				synchronized(timo) {
					try {
                        //停顿1000毫秒，另一个线程有足够的时间占有占用 对象
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
					synchronized(gareen) {
						while(!gareen.isDead()){
							timo.attackHero(gareen, 1000);
				        }
					}
				}
			}
    	};
    	Runnable c = new Runnable() {
			public void run() {
				synchronized(js) {
					synchronized (timo) {
						while(!timo.isDead()){
							js.attackHero(timo, 1000);
				        }
                    }
				}
			}
    	};
    	Thread t = new Thread(a);
    	t.start();

    	Thread tb = new Thread(b);
    	tb.start();

    	Thread tc = new Thread(c);
    	tc.start();

    	
    	prints("盖伦的血量"+gareen.getHp());
    }
}
