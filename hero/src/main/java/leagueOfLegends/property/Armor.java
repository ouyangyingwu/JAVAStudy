package main.java.leagueOfLegends.property;

// 护甲类，继承物品类
public class Armor extends Item {
	public int armor;  //护甲值
	private boolean consumables = false;
	
	public Armor(String name){
		System.out.println( "这是Armor的名字：" +name  );
		this.name = name;
	}
	
	public static void main(String[] args) {
		Armor zj =  new Armor("忍者足具");
		zj.price = 1100;
		zj.armor = 20;
		
		System.out.println("打印对象： " + zj.price);
		/*
		 * 	Item 的匿名内部类
		*/
		Item chain = new Item() {
			public Item disposable(Item obj) {
				print("匿名类实现抽象方法");
				if(consumables) 
					return null;
				else
					return obj;
			}
		};
		chain.price = 800;
		chain.name = "锁子甲";
		chain.disposable(chain);
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
