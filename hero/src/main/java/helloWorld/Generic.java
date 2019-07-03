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
public class Generic {
	
	/*
	 * 	一个泛型方法
	*/
	public static <T> int test(T num) {
		System.out.println(getType(num)); 		/* 传入参数的类型 */
		return 11;
	}
	
	public static void main(String[] args) 
	{ 
		int i=1; //int类型变量
		System.out.println(getType(i)); //打印变量类型为int
		
		System.out.println(test((byte)21)); 
	} 
	
	public static String getType(Object o){ //获取变量类型方法
		Object c = o.getClass();
		System.out.println(c+"HHHH"); 
		return o.getClass().toString(); //使用int类型的getClass()方法
	} 
}
