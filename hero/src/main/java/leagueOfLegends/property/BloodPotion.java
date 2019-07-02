package main.java.leagueOfLegends.property;

/*
 *血瓶
 */
public class BloodPotion extends Item {
	public final String name = "血瓶";
	public final int price = 50;							//	价格
	public final int recoveryValue = 150;		//	总回复血量
	public final int recoveryTime = 5;				//	作用时间
	
	public static void main(String[] ages) {
		BloodPotion blood = new BloodPotion();
		blood.effect();
	}
	
	public void effect(){
        System.out.println("血瓶使用后，可以回血");
    }
}
