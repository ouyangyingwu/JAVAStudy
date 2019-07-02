package main.java.leagueOfLegends.property;

/*
 *	腐败药水
 */
public class CorruptionPotion extends Item {
	public final String name = "腐败药水";
	public final int price = 500;						//	价格
	public final int recoveryValue = 125;		//	总回复血量
	public final int magicValue = 75;				//	总回复蓝量
	public final int recoveryTime = 12;			//	作用时间
	public int number = 3;								//	可用次数
	
	public static void main(String[] ages) {
		CorruptionPotion  corruption = new CorruptionPotion();
		corruption.effect();
	}
	
	public void effect(){
        System.out.println("腐败药水使用后，可以回血回蓝");
    }
}
