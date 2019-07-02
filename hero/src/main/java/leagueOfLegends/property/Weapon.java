package main.java.leagueOfLegends.property;

/*
 * 	 武器类，继承物品类
*/
public class Weapon extends Item {
	int damage; //攻击力
	private boolean consumables = false; 
	
	public static void main(String[] args) {
		Weapon wj =  new Weapon();
		wj.name = "无尽之刃";
		wj.price = 3600;
		wj.damage = 65;
    }
	
	@Override
	public Item disposable(Item obj) {
		// TODO Auto-generated method stub
		if(consumables) 
			return null;
		else
			return obj;
	} 
}
