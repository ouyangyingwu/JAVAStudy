package main.java.leagueOfLegends;

import java.util.Scanner;

//如果你不加 public 或 private 则默认为 friendly(包权限,只能被同文件夹下的的类访问) 权限,类、方法.属性都是;
public class Hero {
	public String name;
	public float hp;
	public float armor;
	public int moveSpeed;
	
	public int killed = 0;			//死亡次数
	int kill = 0;				//击杀次数
	int support = 0;			//助攻次数
	int money = 0;				//金钱
	int lastHit = 0;		//补刀
	int demolitionTower = 0;//推塔数量
	int attackSpeed;		//攻速
	String wordAfterKill;	//击杀后的话
	String wordAfterKilled;	//死亡后的话

	public static void main(String[] args) {
        Hero garen =  new Hero();
        garen.name = "盖伦";
        garen.hp = 616.28f;
        garen.armor = 27.536f;
        garen.moveSpeed = 350;
        garen.wordAfterKill = "人在塔在";
        garen.wordAfterKilled = "等着我的大宝剑吧";

        Hero teemo =  new Hero();
        teemo.name = "提莫";
        teemo.hp = 383f;
        teemo.armor = 14f;
        teemo.moveSpeed = 330;
        teemo.wordAfterKill = "正在待命";
        teemo.wordAfterKilled = "呵呵呵";
        
        Scanner scanner = new Scanner(System.in);
        int bmi = scanner.nextInt();
        if(bmi > 0) {
        	switch(bmi) {
    		case 1: System.out.println("这是1 "+ bmi );
    		case 2: System.out.println("这是2 "+ bmi);
    		case 3: System.out.println("这是3 "+ bmi );
    		case 4: System.out.println("这是4 "+  bmi );break;
    		case 5: System.out.println("这是5 "+  bmi );
    		}
        }
        scanner.close();	//关闭Scanner对象；
    }
	
	//表示该方法没有返回值（void）
	public void killedChange(int text){
		killed ++;
	}
	public void killChange(String text){
		kill ++;
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
	
	public void recovery(float blood) {
		hp += blood;
	}
	
	
	
	
	
	
	
	
	
	
	//...
	//坑队友
    void keng(){
        System.out.println("坑队友！");
    }
 
    //获取护甲值
    float getArmor(){
        return armor;
    }
     
    //增加移动速度
    void addSpeed(int speed){
        //在原来的基础上增加移动速度
        moveSpeed = moveSpeed + speed;
    }
}
