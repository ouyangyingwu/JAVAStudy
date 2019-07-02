package main.java.leagueOfLegends.property;

// 武器类，继承物品类
public class Weapon extends Item {
	int damage; //攻击力
	
	public static void main(String[] args) {
		Weapon wj =  new Weapon();
		wj.name = "无尽之刃";
		wj.price = 3600;
		wj.damage = 65;
    }  
}
