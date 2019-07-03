package main.java.leagueOfLegends.animal;

public class Fish extends Animal {
	private String name = "鱼";
	
	protected Fish() {
		super(0);
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
	}
	
	public void walk() {
		print(this.name+" 没有腿在，在水里游");
	}
	
	public static void main(String[] ages) {
		/*
		 *	练习-装箱拆箱
		*/
		byte b = 10;
		short s = 20;
		int i = 30;
		long l = 30L; 
		float f = 30.5f;
		double d = 50;
	
		Byte bb = 80;
		Byte bbb = 80;
		Short ss = 80;
		Integer ii = 90;
		Long ll = 55L;
		Float ff = 66F;
		Double dd = 77D;
		
		
		Math.sqrt(bb);
		Math.pow(2, 20);
		
		int z = 1000;
		int num = 0;
		while(z > 0) {
			z--;
			if(z < 4 && z > 0) {
				num++;
				continue;
			}
			int c = z/2;
			while(c > 1) {
				if(z%c == 0) {
					break;
				}
				if(c == 2) {
					num++;
					//print("這個质数是："+ z);
				}
				c--;
			}
		}
		print("质数一共有 "+ num +"个");
		System.out.printf("+++6666 %d",dd);
	        
		
	}
	
}
