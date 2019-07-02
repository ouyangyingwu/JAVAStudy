package main.java.leagueOfLegends.charactor;

import main.java.leagueOfLegends.property.Armor;
import main.java.leagueOfLegends.charactor.heroInterface.Healer;

/*
 *  奶妈英雄    
 *  类的转型
 */
public class Support extends Hero implements Healer {
	
	public Support(String heroName, float heroHP, float heroArmor, int heroMoveSpeed) {
		super(heroName, heroHP, heroArmor, heroMoveSpeed);
	}
	public static void main(String[] args) {
		Support nm = new Support("众星之子", 383f, 14f, 330);
        
        Hero h1 =  new Hero("盖伦", 615f, 14f, 330);
        Armor a1 = new  Armor( "锁子甲");
        
        h1.armor += (int)a1.armor;
        
        nm.heal();
        nm.heals(h1);
        nm.heals(h1, 123);
        
        Hero parent = new Support("众星", 383f, 14f, 330);		//向上转型
        Support son = (Support)parent;		//向下转型1,没错
        //Support son1 = (Support)h1;		//向下转型1,运行报错
        
      //判断引用son指向的对象，是否是Support类型
        System.out.println(son instanceof Support);
         
        //判断引用h1指向的对象，是否是Hero的子类型
        System.out.println(h1 instanceof Hero);
    }
	//为指定的英雄加血
	void heals(Hero h) {
		print( "对"+ h.name +" 进行了一次治疗" );
		// System.out.println("对"+ h.name +" 进行了一次治疗");
	}
	//为指定的英雄加了hp的血 (重载)
	void heals (Hero h, int hp){
		print("对"+ h.name +" 进行了一次治疗 ，恢复了："+hp);
	}
	
	/*
	 * 实现治疗接口
	*/
	@Override
	public void heal() {
		// TODO Auto-generated method stub
		print(" 进行了一次治疗" );
	}
	
	
}
