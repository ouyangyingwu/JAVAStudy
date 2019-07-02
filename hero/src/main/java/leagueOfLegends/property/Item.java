package main.java.leagueOfLegends.property;

/*
 * 	物品类、抽象类
 * 
*/
public abstract class Item {
	public String name;
	public int price;
	protected boolean consumables = true;	//	消耗品
	
	Item(){
		System.out.println( "这是Item的构造方法"  );
	}
	
	public static void main(String[] args) {
		System.out.println( "这是Item的main方法"  );
    }
	
	public void effect(){
        System.out.println("物品使用后，可以有效果");
    }

	/*
	 * 	设计的抽象方法
	 * 	因为有抽象方法，类必须改为抽象类
	*/
	public abstract Item disposable(Item obj);
	
	public static void print(String text) {
		 System.out.println(text);
	}
}