package main.java.frame;

import java.util.ArrayList;
import java.util.LinkedList;

import main.java.util.Parents;
import main.java.leagueOfLegends.charactor.Hero;

/*
 * 练习-自定义MyHashMap 
 * 
 * HashMap 原理：
 * -----hashcode概念-----
 * 所有的对象，都有一个对应的hashcode（散列值）
 * 比如字符串“gareen”对应的是1001 (实际上不是，这里是方便理解，假设的值)
 * 比如字符串“temoo”对应的是1004
 * -----保存数据-----
 * 准备一个数组，其长度是2000，并且设定特殊的hashcode算法，使得所有字符串对应的hashcode，都会落在0-1999之间
 * 要存放名字是"gareen"的英雄，就把该英雄和名称组成一个键值对，存放在数组的1001这个位置上
 * 要存放名字是"temoo"的英雄，就把该英雄存放在数组的1004这个位置上
 * 要存放名字是"db"的英雄，就把该英雄存放在数组的1008这个位置上
 * 要存放名字是"annie"的英雄，然而 "annie"的hashcode 1008对应的位置已经有db英雄了，那么就在这里创建一个链表，接在db英雄后面存放annie
 * -----查找数据-----
比如要查找gareen，首先计算"gareen"的hashcode是1001，根据1001这个下标，到数组中进行定位，（根据数组下标进行定位，是非常快速的） 发现1001这个位置就只有一个英雄，那么该英雄就是gareen.
比如要查找annie，首先计算"annie"的hashcode是1008，根据1008这个下标，到数组中进行定位，发现1008这个位置有两个英雄，那么就对两个英雄的名字进行逐一比较(equals)，因为此时需要比较的量就已经少很多了，很快也就可以找出目标英雄
这就是使用hashmap进行查询，非常快原理。
*/
public class MyHashMap<T>  extends Parents {
	@SuppressWarnings("unchecked")
	LinkedList<Entry>[] entrys=new LinkedList[1999];

	/*
	 * 	练习-自定义字符串的hashcode
	*/
	private static int hashcode(String str) {
		int code = 0;
		char[] c = str.toCharArray();
		for(char v : c) {
			code += (int)v; 
		}
		code = code*23 > 1999 ? code*23%2000 : code*23;
		return code;
	}
	
	public void put(String key,T value){
		int index = hashcode(key);
		if (null == entrys[index]) {
			entrys[index] = new LinkedList<Entry>();
			entrys[index].addLast(new Entry(key, value));
		} else {
			// 如果已有该key，覆盖其原对应元素并退出
            for (Entry each : entrys[index]) {
            	if (each.key.equals(key)) {
            		each.value = value;
                    return;
                }
            }
            entrys[index].addLast(new Entry(key, value));
        }
		hashcode(key);
	}
	
	@SuppressWarnings("unchecked")
	public T get(String key){
		int index = hashcode(key);
		T value = null;
        if (null == entrys[index])
            return value;
        for (Entry e : entrys[index]) {
            if (key.equals(e.key)) {
                value = (T)e.value;
                break;
            }
        }
        return value;
	}
	
	public static void main(String[] age) {
		long c1 = System.currentTimeMillis();
		MyHashMap<Hero> map = new MyHashMap<>();
		for(int i=1; i<100000; i++) {
			int name = (int)(Math.random()*10000);
			map.put(String.valueOf(name), new Hero("盖伦"+name, 615f, 14f, 300));
		}
		long c2 = System.currentTimeMillis();
		
		long c3 = System.currentTimeMillis();
		Hero h = map.get("5555");
		long c4 = System.currentTimeMillis();
		
		 long d1 = System.currentTimeMillis();
		ArrayList<Hero> list = new ArrayList<>();
		for(int i=1; i<100000; i++) {
			int name = (int)(Math.random()*10000);
			list.add(new Hero("盖伦"+name, 615f, 14f, 300));
		}
		 long d2 = System.currentTimeMillis();
		
        long d3 = System.currentTimeMillis();
        Hero m = null;
        int count = 0;
        for (int i = 0; i < list.size();i++ ) {
            if (list.get(i).name.equals("盖伦5555")) {
            	m = list.get(i);
            	count++;
            }
        }
        long d4 = System.currentTimeMillis();
		
		prints("map添加数据用时："+(c2-c1));
		prints("map查找数据用时："+(c4-c3)+" 内容为："+h.name);
		
		prints("list添加数据用时："+(d2-d1));
		prints("list查找数据用时："+(d4-d3)+" 内容为："+m.name+" 有 "+count+" 个");

		prints("test");
		MyHashMap mhm = new MyHashMap();
		mhm.put("adc", "测试");
		mhm.put("add", "测试");
		mhm.put("ade", "测试");
		mhm.put("adf", "测试");
		mhm.put("adg", "测试");
		
		//prints(mhm.entrys);
	}
}
