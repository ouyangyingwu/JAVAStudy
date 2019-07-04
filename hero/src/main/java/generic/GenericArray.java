package main.java.generic;

import java.util.ArrayList;

/*
 *	GenericArray 泛型类，
 *
 *	ArrayList 的用法
 *	
 */
public class GenericArray<E> extends  GenericParent {
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
		GenericArray<String> temp1 = new GenericArray<String>();
		// 将对象添加到 ArrayList的结尾处--add(Ee);
		temp1.myAdd(new String("Word"));
		temp1.myAdd(new String("789"));
		temp1.myAdd(new String("Hi!"));
		temp1.myAdd(new String("你好"));
		
		//	
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
