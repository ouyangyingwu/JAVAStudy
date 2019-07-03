package main.java.helloWorld;

/*
 *	Generic 泛型，
 *	在1.5之后，Java引入了泛型(Generic)的概念，提供了一套抽象的类型表示方法。利用泛型，我们可以：
 *	1、表示多个可变类型之间的相互关系：HashMap<T,S>表示类型T与S的映射，HashMap<T, S extends T>表示T的子类与T的映射关系
 *
 *	2、细化类的能力：ArrayList<T> 可以容纳任何指定类型T的数据，当T代指人，则是人的有序列表，当T代指杯子，则是杯子的有序列表，
 *	所有对象个体可以共用相同的操作行为
 *
 *	3、复杂类型被细分成更多类型：List<People>和List<Cup>是两种不同的类型，这意味着List<People> listP = new ArrayList<Cup>()是不可编译的。
 *	后面会提到，这种检查基于编译而非运行，所以说是不可编译并非不可运行，因为运行时ArrayList不保留Cup信息。另外要注意，
 *	即使People继承自Object，List<Object> listO = new ArrayList<People>()也是不可编译的，应理解为两种不同类型。因为listO可以容纳任意类型，
 *	而实例化的People列表只能接收People实例，这会破坏数据类型完整性。
*/
public abstract class GenericParent {
	
	
	public static void main(String[] args) 
	{ 
		int i = 1;
		prints(test3(i));
	}
	
	/*
	 * 	泛型抽象方法，返回参数的类型
	*/
	public abstract <T> T test1(T num);
	
	/*
	 * 	泛型抽象方法，无返回值
	*/
	public abstract <T> void test2(T num);
	
	/*
	 * 	一个泛型静态方法，返回参数的类型
	*/
	public static <T> String test3(T num) {
		return "static 泛类型方法的返回值 "+getType(num);
	}
	
	/*
	 * 	一个泛型静态方法，无返回值
	*/
	public static <T> String test4(T num) {
		return "static 泛类型方法的返回值 "+getType(num);
	}
	
	/*
	 * 	一个泛型方法，返回参数的类型
	*/
	public <T> String test5(T num) {
		return "普通 泛类型方法的返回值 "+getType(num);
	}
	
	/*
	 * 	一个泛型方法，无返回值
	*/
	public <T> void test6(T num) {
		prints("普通 泛类型方法的返回值 "+getType(num));
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
	public static <T>void prints(T commetn){ 
		System.out.println(commetn);
	}
}
