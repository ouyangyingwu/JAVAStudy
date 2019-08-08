package main.java.leagueOfLegends.charactor;
import main.java.util.Parents;


import main.java.leagueOfLegends.property.*;
import main.java.leagueOfLegends.charactor.heroInterface.Mortal;

import java.io.Serializable;
import java.util.Scanner;

//如果你不加 public 或 private 则默认为 friendly(包权限,只能被同文件夹下的的类访问) 权限,类、方法.属性都是;
public class Hero extends Parents implements Serializable {
	public String name;
	public float hp;
	public float currentHp;		//当前血量
	public float armor;				//护甲
	public int moveSpeed;		//移动速度
	public int damage;				//攻击力
	
	public int killed = 10;			//死亡次数
	int kill = 0;							//击杀次数
	int support = 0;					//助攻次数
	int money = 0;					//金钱
	int lastHit = 0;						//补刀
	int demolitionTower = 0;	//推塔数量
	int attackSpeed;					//攻速
	String wordAfterKill;			//击杀后的话
	private static String wordAfterKilled = "死了死了";		//死亡后的话
	
	private static final long serialVersionUID = 1L;
	/*
	 * 	-------战斗成绩内部类------
	 * 	非静态内部类，等同于类一个特殊特殊成员
	 * 	只有一个外部类对象存在的时候，才有意义
	*/
	class BattleScore {
        int kill;
        int die;
        int assit;
 
        public void legendary() {
            if (kill >= 8)
                System.out.println(name + "超神！");
            else
                System.out.println(name + "尚未超神！");
        }
    }
	/*
	 * 	-------敌方的水晶静态内部类------
	 * 	静态内部类，需要用 static 修饰
	 * 	静态类只能访问外部类的静态属性方法
	*/
    static class EnemyCrystal{
        int hp=5000;
         
        //如果水晶的血量为0，则宣布胜利
        public void checkIfVictory(){
            if(hp==0){
                Hero.battleWin();
                //静态内部类不能直接访问外部类的对象属性
                System.out.println(wordAfterKilled + " 静态内部类的方法");
            }
        }
    }

	public static void main(String[] args) {
//        Hero garen =  new Hero("盖伦", 615f, 14f, 300);
//        garen.wordAfterKill = "人在塔在";
//        garen.wordAfterKilled = "等着我的大宝剑吧";
//
//        Hero teemo1 =  new Hero("提莫", 383f, 14f, 300);
//        teemo1.wordAfterKill = "正在待命";
//        teemo1.wordAfterKilled = "呵呵呵";
//        
        Scanner scanner = new Scanner(System.in);
//        int bmi = scanner.nextInt();
//        if(bmi > 0) {
//        	switch(bmi) {
//    		case 1: System.out.println("这是1 "+ bmi );
//    		case 2: System.out.println("这是2 "+ bmi);
//    		case 3: System.out.println("这是3 "+ bmi );
//    		case 4: System.out.println("这是4 "+  bmi );break;
//    		case 5: System.out.println("这是5 "+  bmi );
//    		}
//        }
        scanner.close();	//关闭Scanner对象；
        
        
        Hero teemo = new Hero("提莫", 383f, 14f, 300);
        teemo.hp = teemo.hp - 400;
        
        teemo.revive(teemo);
         
        System.out.println(teemo.hp + "  " + teemo.killed); //输出多少？ 怎么理解？
        
        BloodPotion hp =new BloodPotion();
        CorruptionPotion hpMp =new CorruptionPotion();
        teemo.useItem(hp);
        teemo.useItem(hpMp);	
        //	多态作业
        Hero garen =  new Hero("盖伦", 615f, 14f, 300);
        ADHero sj = new ADHero("赏金", 615f, 14f, 300,80);
        APHero yj = new APHero("妖姬", 615f);
        ADAPHero fj = new ADAPHero("飞机", 615f, 14f, 300,80,10);
        
        garen.killChange(sj);
        garen.killChange(yj);
        garen.killChange(fj);
		/*
		 * 	实例化内部类
		 * 	必须先实例化外部类
		*/
        BattleScore score = garen.new BattleScore();
        score.legendary();
        /*
		 * 	实例化静态内部类
		*/
        Hero.EnemyCrystal crystal = new Hero.EnemyCrystal();
        crystal.hp = 0;
        crystal.checkIfVictory();
        /*
		 *	局部(本地)内部类
		*/
        class SomeHero extends Hero {
        	//构造函数重载
        	public SomeHero(String name,float hp) {
        		super(name , hp);
        	}
            public void attack() {
                System.out.println( name+ " 新的进攻手段");
            }
        }
        SomeHero h  =new SomeHero("诡术妖姬", 560);
        h.attack();
    }
	
	/*
	 * 	多态的实现
	 * 执行步骤一：声明 Item 类型引用 i 指向传过来的对象从而实现了类型向上转换；
	 * 执行步骤二：调用 Item 类的effect方法；
	 * 执行步骤三：查看是否在指向对象内重写，如果有则执行指向对象的，否则执行Item的方法；
	*/
	public void useItem(Item i) {
		i.effect();
    }
	
	private static void battleWin(){
        System.out.println("battle win");
    }
	
    //复活
    public void revive(Hero h){
    	// h 先是指向传过来的对象
    	 System.out.println(h.hp); 
    	
        h = new Hero("提莫",383);
        // h 的指向改为了新对象的指向，但是并没有修改原对象的指向
        System.out.println(h.hp); 
    }
	
	//构造方法
	public Hero(String name, float hp, float armor, int damage) {
		//this(name, hp);
		this.name = name;
		this.hp = hp;
		this.currentHp = hp;
		this.armor = armor;
		this.damage = damage;
	}
	//构造函数重载
	public Hero(String name,float hp) {
		this.name = name;
        this.hp = hp;
        this.currentHp = hp;
		System.out.println(name+"  的对血量是: "+ hp);
	}
	
	//打印函数
	public static void print(String comment) { 
		 System.out.println( comment );
	 }
	
	//表示该方法没有返回值（void）
	public void killedChange(int text){
		killed ++;
	}
	public void killChange(Mortal obj){
		this.kill ++;
		obj.die();
		print(this.name+" 击杀了 "+this.kill+ "个英雄");
		legenderay(kill);
	}
	public void supportChange(String text){
		support ++;
	}
	public void demolitionTowerChange(String text){
		demolitionTower ++;
	}
	
	void legenderay(int kill) {
		if(kill >= 8) {
			System.out.println(name+" 超神了！");
		}
	}
	
	public float getHp() {
		return hp;
	}
	public String getName() {
		return this.name;
	}
	
	public void recovery(float blood) {
		hp += blood;
	}
	public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", armor=" + armor + "]\r\n";
    }
	
	public boolean matched() {
		return (this.hp > 100 && this.armor < 50);
	}
	public  int compare(Hero h1, Hero h2) {
		 return h1.hp<=h2.hp ? 1 : -1;
	}
	
	//...
	//坑队友
    void keng(){
        System.out.println("坑队友！");
    }
 
    //获取护甲值
    public float getArmor(){
        return this.armor;
    }
     
    //增加移动速度
    void addSpeed(int speed){
        //在原来的基础上增加移动速度
        moveSpeed = moveSpeed + speed;
    }
    
    public boolean isDead() {
        return 0>=this.currentHp?true:false;
    }

	public void attackHero(Hero h, int n) {
		try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(n);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		h.currentHp -= this.damage;
		System.out.format("%s 正在攻击 %s, %s 的血变成了 %.0f%n",name,h.name,h.name,h.currentHp);
		if(h.isDead())
            System.out.println(h.name +"死了！");
	}

	// 自动回血
	public synchronized void recover() {
		this.currentHp += 1;
		// 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
		if(this.currentHp >= this.hp) {
			this.currentHp = this.hp;
			this.notify();
		}
		System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, currentHp);
	}
	// 泉水回血
	public synchronized void recovers() {
		this.currentHp += 100;
		System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, currentHp);
        // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
        this.notify();
		if(this.currentHp > this.hp);
			//this.currentHp = this.hp;
	}
	// 掉血
    public synchronized void hurt(){
    	if (currentHp == 1) {
            try {
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    	this.currentHp -= 1;
    	System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, currentHp);
    	if(this.currentHp < 0) {
    		//this.currentHp = 0;
    		System.out.printf("%s 死了", this.name);
    	}
    }
}
