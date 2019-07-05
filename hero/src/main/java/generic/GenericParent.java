package main.java.generic;

/*
 *	GenericParent 泛型类，
 *	在1.5之后，Java引入了泛型(Generic)的概念，提供了一套抽象的类型表示方法。
 *	1、用上限通配符定义“in”变量。(使用extends关键字)
 * 	2、用下限通配符定义“out”变量。（使用super关键字）
 * 	3、在可以使用Object类中定义的方法访问“in”变量的情况下，使用无界通配符。
 * 	4、在代码需要通过“in”和“out”变量访问其他变量的情况下，不要使用通配符。
 * 
 * 	泛类型限制：
 *	1、无法使用基本数据类型实例化泛型类
 *	2、无法创建类型参数的实例，public static <E> void append(List<E> list) {E elem = new E();  // compile-time error}
 *	3、无法申明静态变量为泛类型
 *	4、无法强制转换或使用 instanceof
 *	5、无法创建参数化类型的数组
 *	6、无法直接或间接扩展 Throwable 类，无法捕获类型参数的实例
 *	7、类型擦除到原生类型的方法无法重载
 *
 *	有界泛类型 要实现有界泛型类型，只需要在泛型类型后面追加extends 父类型即可
 *	例如： <T extends Number & Comparable & Map> //T标识一个泛型类型，其类型只能是Person类型的子类，并且实现了Comparable 和Map接口
 */
public abstract class GenericParent<U> implements Generic<U> {
	
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
	public <T extends GenericParent<?>> String test5(T num) {
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
