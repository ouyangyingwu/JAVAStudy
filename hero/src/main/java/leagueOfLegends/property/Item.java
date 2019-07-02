package main.java.leagueOfLegends.property;

import main.java.leagueOfLegends.property.itemInterface.*;

public class Item extends  Disposable {
	public String name;
	public int price;
	
	Item(){
		System.out.println( "这是Item的构造方法"  );
	}
	
	public static void main(String[] args) {
		Item xp =  new Item();
		xp.name = "血瓶";
		xp.price = 50;
		
		Item cx =  new Item();
		cx.name = "草鞋";
		cx.price = 300;
		
		Item cj =  new Item();
		cj.name = "长剑";
		cj.price = 350;
		
		System.out.println( "这是Item的main方法"  );
    }
	
	public void effect(){
        System.out.println("物品使用后，可以有效果");
    }

	/*
	 * 	实现 Disposable 的抽象方法
	*/
	@Override
	public boolean disposable(Object obj) {
		// TODO Auto-generated method stub
		obj = null;
		return false;
	}
}