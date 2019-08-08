package main.java.thread;

import main.java.util.Parents;
import main.java.leagueOfLegends.charactor.Hero;

/*
 * 线程交互
*/
public class MyThreadInteraction<T> extends Parents{
     
	public static void main(String[] args) {
		
        // 用法示例
//		test();
		
		// 练习一
//        Interaction();
		
     // 练习二
        Interactions();
     // 练习三
	}
	/*
	 * 使用wait和notify进行线程交互
	*/
	static void test() {
		final Hero gareen = new Hero("盖伦", 616);
		
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                     
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
   
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();
   
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
	}

	/*
	 * 练习-线程交互
	 * 假设加血线程运行得更加频繁，英雄的最大血量是1000
	 * 设计加血线程和减血线程的交互，让回血回满之后，加血线程等待，直到有减血线程减血
	 * 
	 * 运行结果：先加减血同时运行，因为减血频率稍高最终血量为一；减血线程释放占用并且等待，直到血量达到最大值；无限循环；
	*/
	static void Interaction() {
		final Hero gareen = new Hero("盖伦", 1000);
		
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
	}

	/*
	 * 练习-多线程交互
	 * 在上面的练习的基础上，增加回血线程到2条，减血线程到5条，同时运行。
	 * 运行一段时间，观察会发生的错误，分析错误原因，并考虑解决办法
	*/
	private static void Interactions() {
		final Hero gareen = new Hero("盖伦", 100);
		
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
        Thread t3 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t3.start();
        Thread t4 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t4.start();
        Thread t5 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t5.start();
        
        Thread tt1 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        tt1.start();
        Thread tt2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        tt2.start();
	}
}
