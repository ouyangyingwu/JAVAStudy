package main.java.lambda;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import main.java.leagueOfLegends.charactor.Hero;
import main.java.util.Parents;

/*
 *	Lambda 的聚合
*/
public class LambdaStream extends Parents {
	
	public static void main(String[] args) {
		Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100), 10));
        }
 
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("查询条件：hp>100 && damage<50");
        System.out.println("通过传统操作方式找出满足条件的数据：");
 
        for (Hero h : heros) {
            if (h.hp > 100 && h.armor < 50)
                System.out.println(h.name);
        }
 
        System.out.println("通过聚合操作方式找出满足条件的数据：");
        
		/*
		 * 管道源：在这个例子里，源是一个List
		 * 				 如果管道源是普通数组，调用方法为 Arrays.stream(heros); / Stream.of(heros);
		 * 
		 * 中间操作：每个中间操作，又会返回一个Stream，比如.filter()又返回一个Stream, 中间操作是“懒”操作，并不会真正进行遍历。
		 * 					 对元素进行筛选：filter 匹配、distinct 去除重复(根据equals判断)、sorted 自然排序、sorted(Comparator<T>) 指定排序、limit 保留、skip 忽略
		 * 					 转换为其他形式的流：mapToDouble 转换为double的流、map 转换为任意类型的流
		 * 
		 * 结束操作：当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。 结束操作不会返回Stream，但是会返回int、float、
		 * 					 String、 Collection或者像forEach，什么都不返回, 结束操作才进行真正的遍历行为，在遍历的时候，才会去进行中间操作的相关判断；
		 * 					 常见结束操作如下：、forEach() 遍历每个元素、toArray() 转换为数组、min(Comparator<T>) 取最小的元素、max(Comparator<T>) 取最大的元素、
		 * 													count() 总数、findFirst() 第一个元素
		 * 					min、max、findFirst需要get获取其中的值，否则会返回 Optional<Hero>数组；
		 * 
		 * 注： 这个Stream和I/O章节的InputStream,OutputStream是不一样的概念。
		*/
        heros
            .stream()
            .filter(h -> h.hp > 100 && h.armor < 50)
            .limit(5)	//	保留几个数据,从前面算起
            .sorted((h1,h2)->h1.hp > h2.hp ? 1 : -1)	//	按照 hp 排序
            .distinct()	//	去重
            .skip(0)	//	忽略几个数据，从前面开始算起
            .forEach(h -> prints(h.name));
           
        System.out.println("转换为double的Stream");
        heros
            .stream()
            .mapToDouble(Hero::getHp)
            .forEach(h->System.out.println(h));
          
        System.out.println("转换任意类型的Stream");
        heros
            .stream()
            .map((h)-> h.name + " - " + h.hp + " - " + h.armor)
            .forEach(h->System.out.println(h));
          
        
        System.out.println("返回一个数组");
        Object[] hs= heros
            .stream()
            .toArray();
        System.out.println(Arrays.toString(hs));
        System.out.println("返回伤害最低的那个英雄");
        Hero minDamageHero =
        heros
            .stream()
            .min((h1,h2)->h1.armor>h2.armor?1:-1)
            .get();
        System.out.print(minDamageHero);
        System.out.println("返回伤害最高的那个英雄");
 
        Hero mxnDamageHero =
                heros
                .stream()
                .max((h1,h2)->h1.armor>h2.armor?1:-1)
                .get();
        System.out.print(mxnDamageHero);     
         
        System.out.println("流中数据的总数");
        long count = heros
                .stream()
                .count();
        System.out.println(count);
 
        System.out.println("第一个英雄");
        Hero firstHero =
                heros
                .stream()
                .findFirst()
                .get();
        System.out.println(firstHero);
        
        System.out.println("第一个英雄："+heros
                .stream()
                .findFirst().get().name);
        
        work( r );
    }

	/*
	 * 练习-聚合操作
	 * 首选准备10个Hero对象，hp和armor都是随机数。
	 * 分别用传统方式和聚合操作的方式，把hp第三高的英雄名称打印出来
	*/
	private static void work(Random r ) {
		List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100), 10));
        }
        
        prints("初始化数组："+heros.toString());
        for(int i = 0; i < 10; i++){
        	 for(int j = 0; j < 10; j++){
            	if(heros.get(i).hp > heros.get(j).hp) {
            		Hero temp = heros.get(i);
            		heros.set(i, heros.get(j));
            		heros.set(j, temp);
            	}
            }
        }
        prints("排序后数组："+heros.toString());
        prints("目标对象："+ heros.get(2).toString());
        
        //	混淆数组
        Collections.shuffle(heros);
        prints("混淆后数组："+heros.toString());
        
        prints("聚合操作获得的目标对象："+heros
        		.stream()
        		.sorted( (h1,h2)-> h1.hp < h2.hp ? 1 : -1)	//	hp降序排列
        		.skip(2)														//	忽略前面两个
        		.findFirst().get()											//	取得第一个
        		);
	}
}
