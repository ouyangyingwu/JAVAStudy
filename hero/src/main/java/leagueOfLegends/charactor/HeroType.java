package main.java.leagueOfLegends.charactor;

//  英雄中有这么一些分类
public class HeroType {
	public enum Type {
		TANK ,
		WIZARD,
		ASSASSIN ,
		ASSIST ,
		WARRIOR ,
		RANGED  ,
		PUSH  ,
		FARMING  
	}
	
	public static void main(String[] ages) {
		 for (Type t : Type.values()) {
			 switch(t) {
			 case TANK:
		            System.out.println("春天 TANK");
		            break;
			 case WIZARD:
		            System.out.println("春天 WIZARD");
		            break;
			 case ASSASSIN:
		            System.out.println("春天 ASSASSIN");
		            break;
			 case ASSIST:
		            System.out.println("春天 ASSIST");
		            break;
			 case WARRIOR:
		            System.out.println("春天 WARRIOR");
		            break;
			 case RANGED:
		            System.out.println("春天 RANGED");
		            break;
			 case PUSH:
		            System.out.println("春天 PUSH");
		            break;
			 case FARMING:
		            System.out.println("春天 FARMING");
		            break;
		            }
			 }
		 }
}
