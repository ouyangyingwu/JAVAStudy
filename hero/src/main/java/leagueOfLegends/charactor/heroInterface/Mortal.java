package main.java.leagueOfLegends.charactor.heroInterface;

/*
 * 	死亡接口
*/
public interface Mortal {
	
	/*
	 * 	死亡方法
	*/
	public void die();

	/*
	 * 	默认方法是JDK8新特性，指的是接口也可以提供具体方法
	*/
	default public void revive() {
        System.out.println("本英雄复活了");
    }
}
