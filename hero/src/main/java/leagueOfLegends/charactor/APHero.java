package main.java.leagueOfLegends.charactor;

import main.java.leagueOfLegends.charactor.heroInterface.Mortal;

public class APHero extends Hero implements Mortal {
	
	public APHero(String name, float hp) {
		super(name, hp);
		// TODO Auto-generated constructor stub
	}
	
	 /*
	  *  实现接口的方法
	  */
	public void die() {
		print("AP英雄阵亡了");
	}
}
