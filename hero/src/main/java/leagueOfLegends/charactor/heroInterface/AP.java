package main.java.leagueOfLegends.charactor.heroInterface;

import main.java.leagueOfLegends.charactor.ADAPHero;

/*
 * 魔法攻击接口
 */
public interface AP {
		//		物理伤害
	    public void magicAttack (ADAPHero temp);
	    
	    default void attack(){
	    	System.out.println("我是AP接口的默认方法 attack"); 
	    }
}
