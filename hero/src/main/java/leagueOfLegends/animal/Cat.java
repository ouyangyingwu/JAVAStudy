package main.java.leagueOfLegends.animal;

public class Cat extends Animal implements Pet {
	String name;
	
	public Cat(String name) {
		super(4);
		this.name = name;
	}
	
	public Cat() {
		this("");
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name)	{
		this.name = name;
	}
	
	public void play() {
		print("这是 play 方法");
	}
	
	public void eat() {
		print("这是 eat 方法");
	}
}
