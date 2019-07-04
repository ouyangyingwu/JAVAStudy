package main.java.generic;

import main.java.leagueOfLegends.charactor.ADAPHero;
import main.java.leagueOfLegends.charactor.heroInterface.AD;

/*
 *	Generic 泛型
*/
public class Generic<S extends Object , U extends Object, D> extends GenericParent  implements AD<D> {
	
	public static void main(String[] args) { 
		
		int i=1;
		
		String str = "";
		
		// 调用父类的静态泛型方法
		prints(test3( i ));
		test4( str );
		
		// 调用父类的泛型对象方法
		Generic<Object,Object,Object> temp = new Generic<>();
		prints(temp.test5(temp));
		temp.test6( 20 );
	}

	/*
	 * 	实现 GenericParent 类的抽象方法
	*/
	@Override
	public <T> T test1(T num) {
		// TODO Auto-generated method stub
		return num;
	}

	@Override
	public <T> void test2(T num) {
		// TODO Auto-generated method stub
		
	} 
	@Override
	public void physicAttack(ADAPHero temp) {
		
	}
}
