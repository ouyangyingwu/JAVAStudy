package main.java.generic;

import java.util.HashMap;

/*
 *	GenericArray 泛型类，
 *
 *	键值对的使用
 *	
 */
public class GenericMapping<K ,V,U> extends  GenericParent<U> {
	/*
	 *	映射泛型类型(K, V)：适用于泛型类型作为键值对的泛型定义。
	 */
	 private HashMap<K,V> map = new HashMap<K, V>();
	
	 public void myPut(K key,V value){
	        map.put(key,value);
	        prints("key:" + key.toString() + ",value=" + value.toString());
	    }
	
	public static void main(String[] args) 
	{ 
		GenericMapping<String,Integer,Float> temp1 = new GenericMapping<String, Integer,Float>();
		temp1.myPut("张安", 100);
		temp1.myPut("张龙", 150);
		temp1.myPut("张增智", 200);
		
		prints( temp1.map.size() );
		prints( temp1.map.toString() );
		prints( temp1.test5(temp1) );
		prints( getType(temp1.map) );
		//	返回指定键对应的值
		prints(temp1.map.get("张龙"));
		//	返回键值对
		prints(temp1.map.entrySet());
		//	返回 所有的键
		prints(temp1.map.keySet());
		//	返回 所有的值
		prints(temp1.map.values());
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
