package main.java.generic;

/*
 *	GenericParent 泛型类，
 *	在1.5之后，Java引入了泛型(Generic)的概念，提供了一套抽象的类型表示方法。
 *	抽象
 *	
 */
public abstract class GenericParent {
	
	public static void main(String[] args) 
	{ 
		String i = "1";
		prints(test3(i));
		test4(i);
	}
	
	/*
	 * 	泛型抽象方法，返回参数的类型
	*/
	public abstract <T> T test1(T num);
	
	/*
	 * 	泛型抽象方法，返回参数的类型
	*/
	public abstract <T> void test2(T num);
	
	/*
	 * 	一个泛型静态方法，返回参数的类型
	*/
	public static <T> String test3(T num) {
		return "GenericParent 的 test3 静态 泛类型方法的 返回值 "+getType(num);
	}
	
	/*
	 * 	一个泛型静态方法，无返回值
	*/
	public static <T> void test4(T num) {
		prints( "GenericParent 的 test4 静态 泛类型 无返回值 方法 "+getType(num));
	}
	
	/*
	 * 	一个泛型方法，返回参数的类型
	 * 参数限制：类型 T 必须是 GenericParent 类或它的子类
	*/
	public <T extends GenericParent> String test5(T num) {
		return "GenericParent 的 test5 普通 泛类型 方法的 返回值 "+getType(this);
	}
	
	/*
	 *	一个泛型方法，无返回值
	 *	参数限制：类型 T 必须是 Number 类或它的子类
	*/
	public <T extends Number> void test6(T num) {
		prints("GenericParent 的 test6 普通 泛类型 无返回值 方法 "+getType(num));
	}
	
	/*
	 *	获取变量类型方法
	 *	使用 类型的getClass()方法
	*/
	public static <T> String getType(T variable){
		return variable.getClass().toString();
	}

	/*
	 *	升级版打印方法，参数可以是任意类型
	*/
	public static <T> void prints(T commetn){ 
		System.out.println(commetn);
	}
}
