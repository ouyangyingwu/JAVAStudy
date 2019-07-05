package main.java.generic;

import java.util.ArrayList;

/*
 *	GenericArray 泛型类，
 *
 *	ArrayList 的用法：
 *	优点：1。支持自动改变大小的功能		2。可以灵活的插入元素		3。可以灵活的删除元素
 *	局限：跟一般的数组比起来，速度上差些
 *	
 */
public class GenericArray<E,U> extends  GenericParent<U> {
	/*
	 *	集合泛型类型：E, 创建一个任意类型的数组； 
	 */
	private ArrayList<E> list = new ArrayList<E>();
	
	public void myAdd(E e){
		list.add(e);
        prints("---  "+e.toString());
    }
	
	public static void main(String[] args) 
	{ 
		GenericArray<String,Integer> temp1 = new GenericArray<String,Integer>();
		// 将对象添加到 ArrayList的结尾处--add(Ee);
		temp1.myAdd(new String("Word"));
		temp1.myAdd(new String("789"));
		temp1.myAdd(new String("Hi!"));
		temp1.myAdd(new String("你好"));
		// 通过下标删除元素
		temp1.list.remove(1);
		// 直接删除指定值的元素
		temp1.list.remove("你好");
		//	更新指定下标的内容
		temp1.list.set(1,"你好吗");
		//	添加元素
		temp1.list.add("吗");
		//	数组排序
		java.util.Collections.sort(temp1.list);
		
		//	数组长度
		prints( temp1.list.size() );
		prints( temp1.list.toString() );
		prints( temp1.test5(temp1) );
		prints( getType(temp1.list) );

	}
	
	/*
	 * 	实现父类 GenericParent 的 test1 抽象方法
	*/
	@Override
	public <T> T test1(T num) {
		return num;
	};
	
	/*
	 * 	实现父类 GenericParent 的 test2 抽象方法
	*/
	@Override
	public <T> void test2(T num) {	
		
	};
}
