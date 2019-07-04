package main.java.leagueOfLegends.charactor.heroInterface;

import main.java.leagueOfLegends.charactor.ADAPHero;

/*
 *	物理攻击接口
 * 	接口中的实体方法 必须用 default 修饰
*/
public interface AD<D> {
	//	默认常量 ，即前面默认了public static final修饰
	 int percentage = 8;
	 //	物理伤害
    public abstract void physicAttack(ADAPHero temp);

	/*
	 * 	接口中的默认方法,	可以有多个
	*/
    default void haha(){
    	System.out.println("我是个接口默认方法 haha"); 
    }
    default void attack(){
    	System.out.println("我是AD接口的默认方法 attack"); 
    }
}
