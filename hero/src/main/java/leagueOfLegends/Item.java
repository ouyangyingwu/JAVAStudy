package main.java.leagueOfLegends;

public class Item {
	String name;
	int price;
	
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
		
		Hero obj = new Hero();
		obj.kill = 1;
    }  
}