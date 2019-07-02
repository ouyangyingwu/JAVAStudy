package main.java.leagueOfLegends.property;

// 护甲类，继承物品类
public class Armor extends Item {
	public int armor;  //护甲值
	
	public Armor(String name){
		System.out.println( "这是Armor的名字：" +name  );
		this.name = name;
	}
	
	public static void main(String[] args) {
		Armor zj =  new Armor("忍者足具");
		zj.price = 1100;
		zj.armor = 20;
		
		Armor chain =  new Armor( "锁子甲");
		chain.price = 800;
		chain.armor = 40;
		
		System.out.println("打印对象： " + zj.price);
    } 
}
