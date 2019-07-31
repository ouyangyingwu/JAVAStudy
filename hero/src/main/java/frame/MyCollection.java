package main.java.frame;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import main.java.util.Parents;

/*
 * Collection是 Set List Queue和 Deque的接口
 * Queue: 先进先出队列
 * Deque: 双向链表
 * 
 * 注：Collection和Map之间没有关系，Collection是放一个一个对象的，Map 是放键值对的
 * 注：Deque 继承 Queue,间接的继承了 Collection
 * 
 * 	HashSet： 无序
 * LinkedHashSet： 按照插入顺序
 * TreeSet： 从小到大排序
*/
public class MyCollection extends Parents {
	public static void main(String[] args) {
		//	反转 reverse
		
		//	混淆	shuffle
		
		//	排序	sort
		
		// 交换	swap
		
		// 滚动	rotate
		
		// 线程安全 synchronizedList 把非线程安全的List转换为线程安全的List
		
		//	练习
		shuffeList();
		randomNumber();
		reverseMap();
		printPI();
    }
	
	/*
	 * 首先初始化一个List,长度是10，值是0-9
	 * 然后不断的shuffle，直到前3位出现
	 * 3 1 4
	 * shuffle 1000,000 次，统计出现的概率
	*/
	private static void shuffeList() {
		Integer[] arr = {0,1,2,3,4,5,6,7,8,9};
		List<Integer> list = Arrays.asList(arr);
		prints(list);
		int num = 0;
		for(int i = 0; i < 1000000; i++) {
			Collections.shuffle(list);
			if(list.get(0) == 3 && list.get(1) == 1 && list.get(2) == 4)
				num++;
		}
		 DecimalFormat df=new DecimalFormat("0.000000000000000");//设置保留位数
		 prints(df.format((double)1/3));
		prints("概率："+((float)num/10000)+"%");
	}
	
	/*
	 * 练习-不重复的随机数
	 * 生成50个 0-9999之间的随机数，要求不能有重复的
	*/
	private static void randomNumber() {
		HashSet<Integer> randomArray = new HashSet<>();
		while(true) {
			randomArray.add((int)(Math.random()*10000));
			if(randomArray.size() == 50) break;
		}
		prints(randomArray);
	}
	
	/*
	 * 练习-反转key和value
	 * 使用如下键值对，初始化一个HashMap：
	 * adc - 物理英雄
	 * apc - 魔法英雄
	 * t - 坦克
	 * 
	 * 对这个HashMap进行反转，key变成value,value变成key
	 * 提示： keySet()可以获取所有的key, values()可以获取所有的value
	*/
	private static void reverseMap() {
		HashMap<String, String> hero = new HashMap<>();
		hero.put("adc", "物理英雄");
		hero.put("apc", "魔法英雄");
		hero.put("t", "坦克英雄");
		Set<String> keys = hero.keySet();
		HashMap<String, String> hero1 = new HashMap<>();
		for(String i : keys) {
			hero1.put(hero.get(i), i);
		}
		prints(hero1);
	}
	
	/*
	 * 利用LinkedHashSet的既不重复，又有顺序的特性，把Math.PI中的数字，按照出现顺序打印出来，相同数字，只出现一次
	*/
	private static void printPI() {
		LinkedHashSet<Character> lhs = new LinkedHashSet<>();
		
		char[] c = String.valueOf(Math.PI).toCharArray();
		prints(Arrays.toString(c));
		for(char k : c) {
			if(k == '.')
				continue;
			lhs.add(k);
		}
		prints(lhs);
	}
}
