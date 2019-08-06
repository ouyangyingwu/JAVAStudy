package main.java.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.java.util.Parents;
import main.java.leagueOfLegends.charactor.Hero;

/*
 * 多线程
 * 
 * 进程与线程的区别：
 * 进程：启动一个LOL.exe就叫一个进程。 接着又启动一个DOTA.exe，这叫两个进程。 
 * 线程：线程是在进程内部同时做的事情，比如在LOL里，有很多事情要同时做，比如"盖伦” 击杀“提莫”，同时“赏金猎人”又在击杀“盲僧”，这就是由多线程来实现的。 
*/
public class MyThread extends Parents{
	public static void main(String[] ages) {
        Hero gareen = new Hero("盖伦",616,50,65);
   	 
        Hero teemo = new Hero("提莫",345,30,70);
         
        Hero bh = new Hero("赏金猎人",500,35,75);
         
        Hero leesin = new Hero("盲僧",455,40,65);

//    	Thread 接口实现多线程
//		thread(gareen , teemo, bh, leesin);
//		Runnable 接口实现多线程
//		runnable(gareen , teemo, bh, leesin);
//		匿名类 多线程
		anonymity(gareen , teemo, bh, leesin);

//		多线程搜索文件内容
//     long time1 = System.currentTimeMillis();
//		work();
//		long time2 = System.currentTimeMillis();
//		prints("多线程用时为："+(time2-time1));
		
//		英雄技能充能
		work1();
	}
	
	//	Thread 接口实现多线程
	static void thread(Hero gareen , Hero teemo, Hero bh, Hero leesin) {
		KillThread killThread1 = new KillThread(gareen,teemo);
        KillThread killThread2 = new KillThread(bh,leesin);
        killThread1.start();
        killThread2.start();
	}
	
	//	Runnable 接口实现多线程
	static void runnable(Hero gareen , Hero teemo, Hero bh, Hero leesin) {
		/*
		 * 	battle1 对象实现了Runnable接口，所以有run方法，但是直接调用run方法，并不会启动一个新的线程。
		 * 必须，借助一个线程对象的start()方法，才会启动一个新的线程。
		 * 所以，在创建Thread对象的时候，把battle1作为构造方法的参数传递进去，这个线程启动的时候，就会去执行battle1.run()方法了。
		*/
        Battle battle1 = new Battle(gareen,teemo);
        Battle battle2 = new Battle(bh,leesin);
       
        // Runnable 无法直接调用 setPriority 方法，所以讲其转化为 Thread ，优先级1-10从小到大，默认为5
        Thread t =  new Thread(battle1);
        t.setPriority(1);
        t.start();
        new Thread(battle2).start();	// 没有设置优先级，优先级为5
	}
	
//	使用匿名类 实现多线程
	static void anonymity(Hero gareen , Hero teemo, Hero bh, Hero leesin) {
		/*
		 * 使用匿名类，继承Thread,重写run方法，直接在run方法中写业务代码
		 * 匿名类的一个好处是可以很方便的访问外部的局部变量。
		 * 前提是外部的局部变量需要被声明为final。(JDK7以后就不需要了)。
		*/
		Thread thread = new Thread() {
			public void run(){
                //匿名类中用到外部的局部变量teemo，必须把teemo声明为final，但是在JDK7以后，就不是必须加final的了
                while(!teemo.isDead()){
                	Thread.yield();
                    gareen.attackHero(teemo, 1000);
                }
            }
		};
		
		thread.start();
		// 加入到当前线程,必须在启动一个线程（start()方法执行完）之后才能加入
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Runnable runnable = new Runnable() {
			public void run(){
                //匿名类中用到外部的局部变量teemo，必须把teemo声明为final，但是在JDK7以后，就不是必须加final的了
                while(!leesin.isDead()){
                	bh.attackHero(leesin, 1000);
                }              
            }
		};
		new Thread(runnable).start();
	}

	/*
	 * 练习-同步查找文件内容
	 * 把 练习-查找文件内容 改为多线程查找文件内容
	 * 原练习的思路是遍历所有文件，当遍历到文件是 .java的时候，查找这个文件的内容，查找完毕之后，再遍历下一个文件
	 * 
	 * 现在通过多线程调整这个思路：
	 * 遍历所有文件，当遍历到文件是.java的时候，创建一个线程去查找这个文件的内容，不必等待这个线程结束，继续遍历下一个文件
	*/
	static void work() {
		String str = "shuffle";
		File f = new File("src/main/java");
		File[] files = f.listFiles();
		search(files, str);
	}
	private static void search(File[] files, String str) {
		for(File file : files) {
			if(file.isFile()) {
				if(file.getName().endsWith(".java")) {
					new Thread(()->searchFile(file, str)).start();
				}
			} else {
				File[] list = file.listFiles();
				search(list, str);
			}
		}
	}
	private static void searchFile(File file, String str) {
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line = null;
			for(int i = 1; (line = br.readLine()) != null; i++) {
				//if(line == null) break; 
				if(line.indexOf(str) > -1) {
					prints(file.getAbsolutePath()+" 第 "+i+" 行\n");
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 练习-英雄充能
	 * 
	 * 英雄有可以放一个技能叫做: 波动拳-a du gen。 
	 * 每隔一秒钟，可以发一次，但是只能连续发3次。 
	 * 发完3次之后，需要充能5秒钟，充满，再继续发。
	 * 
	 * 借助本章节学习到的知识点，实现这个效果
	*/
	static void work1() {
		int num = 3;
		num = attack(num);
	}
	private static int attack(int num) {
		if(num == 0) prints("充能中");
		num--;
		prints("使用了一次攻击，还剩 "+num);
		return num;
	}
	private static int  charge() {
		Thread temp = new Thread();
		try {
			temp.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 3;
	}
}
