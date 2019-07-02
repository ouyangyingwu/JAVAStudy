package main.java.leagueOfLegends.animal;

/*
 * 	所有怪物物的抽象父类
*/
public class Spider extends Animal {
	// 构造权限
	protected String name;
	
	protected Spider(int legs, String name) {
		super(legs);
		this.name = name;
		print("Spider 的构造函数");
	}
	
	public void eat() {
		print("Spider 实现的 Animal 的抽象方法");
	}
	
	public static void main(String[] ages) {
		Spider zz = new Spider(8, "蜘蛛");
		zz.walk();
	}
}
