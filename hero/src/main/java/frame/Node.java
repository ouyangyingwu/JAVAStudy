package main.java.frame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import main.java.util.Parents;
import main.java.leagueOfLegends.charactor.Hero;

/*
 *	二叉树由各种节点组成
 *
 *	二叉树特点：
 *	每个节点都可以有左子节点，右子节点
 *	每一个节点都有一个值
 *
 *	二叉树法排序效率比选择和冒泡排序高(最快二叉树、其次选择排序，最慢冒泡排序)
*/
public class Node<T> extends Parents {
	// 左子节点
    public Node<T> leftNode;
    // 右子节点
    public Node<T> rightNode;
    // 值
    public Object value;

	/*
	 *  插入数据
	*/
    public void add(T v) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value = v;
  
        // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同
            if ((Integer) v -((Integer)value) <= 0) {
                if (null == leftNode)
                    leftNode = new Node<T>();
                leftNode.add(v);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new Node<T>();
                rightNode.add(v);
            }
  
        }
  
    }
    public void addAll(T[] array) {
    	for (T i : array) {
            this.add(i);
        }
    }
    
//    	 中序遍历所有的节点
    public List<Object> values() {
    	List<Object> array = new ArrayList<>();
        // 左节点的遍历结果
        if (null != leftNode)
        	array.addAll(leftNode.values());
  
        // 当前节点
        array.add(value);
  
        // 右节点的遍历结果
        if (null != rightNode)
        	array.addAll(rightNode.values());
  
        return array;
    }
    
    public static void main(String[] args) {
    	Integer[] randoms = new Integer[] { 999, 111, 569, 809, 786, 566, 748 ,178, 988, 572, 448, 679 };
  
        Node<Integer> roots = new Node<>();
        roots.addAll(randoms);
        prints(roots.values());
        
        RandomHero();
        HashSetTest();
    }

	/* 
	 *	测试 ArrayList 和 HashList 的性能
	*/
    private static void RandomHero() {
    	long startTime = System.currentTimeMillis();
    	ArrayList<Hero> test = new ArrayList<>();
    	for(int i = 0; i<3000000; i++) {
    		test.add(new Hero("盖伦 "+(int)(Math.random()*10000) ,615f, 14f, 300));
    	}
    	long editTime = System.currentTimeMillis();
    	
    	long startTime1 = System.currentTimeMillis();
    	int num = 0;
    	for(Hero i : test) {
    		if(i.name.equals("盖伦 5555"))
    			num++;
        }
    	long editTime1 = System.currentTimeMillis();
         
         
        long startTime2 = System.currentTimeMillis();
        HashMap<String, Hero> testMap = new HashMap<>();
     	for(int i = 0; i<3000000; i++) {
     		String name = "盖伦 "+(int)(Math.random()*10000);
     		testMap.put(name ,new Hero(name ,615f, 14f, 300));
     	}
        long editTime2 = System.currentTimeMillis();
        
        long startTime3 = System.currentTimeMillis();
        Hero map = testMap.get("盖伦 5555");
        long editTime3 = System.currentTimeMillis();
        
    	prints("创建ArrayList用时："+(editTime-startTime));
    	prints("for查找用时："+(editTime1-startTime1)+" 数量为："+num);
    	prints("HashMap创建用时："+(editTime2-startTime2));
        prints("HashMap查找用时："+(editTime3-startTime3));
        prints(map.name);
        prints(test.size()+"   "+testMap.size());
    }
    
    /* 
	 *	练习-HashSet     顶 折 纠 问  Or    姿势不对,事倍功半! 点击查看做练习的正确姿势
	 *	创建一个长度是100的字符串数组
	 *	使用长度是2的随机字符填充该字符串数组
	 *	统计这个字符串数组里重复的字符串有多少种
	 *	使用HashSet来解决这个问题
	*/
    private static void HashSetTest() {
    	String[] array = randomArr(100,2);
    	prints("获得的数组 "+Arrays.toString(array));
    	HashSet<String> map = new HashSet<>();
    	HashSet<String> hs = new HashSet<>();
    	
    	for(String i : array) {
    		String to = map.toString();
    		map.add(i);
    		if(map.toString().equals(to)) {
    			hs.add(i);
    		}
    	}
    	prints("重复的值有: "+hs.size()+" 个，分别是："+hs);
    }
}
