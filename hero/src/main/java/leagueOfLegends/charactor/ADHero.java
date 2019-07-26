package main.java.leagueOfLegends.charactor;

import java.io.Serializable;

import main.java.leagueOfLegends.charactor.heroInterface.AD;
import main.java.leagueOfLegends.charactor.heroInterface.AP;
import main.java.leagueOfLegends.charactor.heroInterface.Mortal;
import main.java.leagueOfLegends.property.*;

/*
 * 	物理英雄类
 * 	匿名内部类：匿名内部类并不在接口或抽象类中而是在可实例化的类中
*/
public class ADHero extends Hero implements AD<Object>,AP,Mortal, Serializable {
	private static final long serialVersionUID = 1L;
	int attackPower;
	
	//private static final long serialVersionUID = 7237L;
	public static void main(String[] args) {
        ADHero bh = new ADHero("提莫", 383f, 14f, 330, 8);
        bh.name = "赏金猎人";
        
        Hero h1 =  new Hero("盖伦", 615f, 14f, 330);
        Hero h2 = new Hero("提莫", 383f, 14f, 330);
 
        bh.attack(h1);
        bh.attack(h1, h2);
        
        bh.attack1(h1);
        bh.attack1(h1, h2);
        
        // super 练习
        BloodPotion hp =new BloodPotion();
        bh.useItem(hp);
        System.out.println(hp.toString());
		/*
		 * 	匿名内部类，源自AD接口
		*/
        AD<Object> a = new AD<Object>(){
        	@Override
        	public void physicAttack(ADAPHero temp) {
        		System.out.println("接口的匿名内部类.");
        	}
        };
        a.physicAttack(null);
		/*
		 * 调用AD接口的默认(default修饰的)方法
		*/
        bh.haha();
        bh.attack();
    }
	
	// 重写useItem，并在其中调用父类的userItem方法
    public void useItem(Item i) {
        System.out.println("adhero use item");
        super.useItem(i);
    }
	
	//构造方法
	public ADHero(String heroName, float heroHP, float heroArmor, int heroMoveSpeed, int heroAttackPower) {
		super(heroName, heroHP, heroArmor, heroMoveSpeed);
		this.attackPower = heroAttackPower;
	}
	
	public void attack() {
		 System.out.println(name + " 进行了一次攻击 ，但是不确定打中谁了");
	}
	public void attack(Hero h1) {
		 System.out.println(name + "对" + h1.name + "进行了一次攻击 ");
	}
	public void attack(Hero h1, Hero h2) {
		System.out.println(name + "同时对" + h1.name + "和" + h2.name + "进行了攻击 ");
	}
	
	// 可变数量的参数
    public void attack1(Hero... heros) {
        for (int i = 0; i < heros.length; i++) {
            System.out.println(name + " 攻击了 " + heros[i].name);
        }
    }
    
	/*
	 * 	实现接口的方法
	 * 	@Override 是伪代码，可以不写，写上有如下好处: 
	 * 	1、可以当注释用,方便阅读；
	 *	2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。
	 */
    @Override
	public void physicAttack(ADAPHero temp) {
    	this.hp -= 10;
    	System.out.println("受到了物理攻击 , 造成 10 点物理伤害");
	}
    
    /*
	 * 实现接口的方法
	 */
    @Override
	public void magicAttack(ADAPHero temp) {
    	this.hp -= 10;
    	System.out.println("受到了魔法攻击 , 造成 10 点魔法伤害");
	}
    
    /*
	 * 实现接口的方法
	 */
    @Override
    public void die() {
		print("AD英雄阵亡了");
	}
}
