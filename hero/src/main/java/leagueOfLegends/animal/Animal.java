package main.java.leagueOfLegends.animal;

/*
 * 	所有怪物的抽象父类
*/
public abstract class Animal {
	protected int legs;
	
	protected Animal(int legs) {
		this.legs = legs;
		print("Animal 的构造函数");
	}
	
	public abstract void eat();
	
	public void walk() {
		print(this.legs +"条腿在地上爬行");
	}
	
	public static void print(String comment) {
		System.out.println(comment);
	}
	
	public static void main(String[] ages) {
		/*
		 * 	抽象类内的匿名内部类
		*/
		Animal a = new Animal(8) {
			public void eat() {
				print("eat方法");
			}
		};
		a.walk();
	}
}
