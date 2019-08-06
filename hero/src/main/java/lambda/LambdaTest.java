package main.java.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import main.java.leagueOfLegends.charactor.Hero;
import main.java.util.Parents;

/*
 *	lambda
 *
 *	Lambda表达式虽然带来了代码的简洁，但是也有其局限性。
 *	1. 可读性差，与啰嗦的但是清晰的匿名类代码结构比较起来，Lambda表达式一旦变得比较长，就难以理解
 *	2. 不便于调试，很难在Lambda表达式中增加调试信息，比如日志
 *	3. 版本支持，Lambda表达式在JDK8版本中才开始支持，如果系统使用的是以前的版本，考虑系统的稳定性等原因，而不愿意升级，那么就无法使用。
 *	
 *	Lambda比较适合用在简短的业务代码中，并不适合用在复杂的系统中，会加大维护成本。
*/
public class LambdaTest extends Parents {
	
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100),100));
		}
		System.out.println("初始化后的集合：");
		System.out.println(heros);
				
		// lambda 的演化
//		lambdaHistory(heros);
		//	作业一
//		work1(heros);
        
		// lambda 引用静态方法
//        lambdaStaticFunction(heros);

		// lambda 引用对象方法
        lambdaObjectFunction(heros);
        
        //	引用构造器
//        lambdaConstructor();
        
        //	作业二
        work2(heros);
        
//    	作业三
        work3(heros);
    }
	
	// lambda 的演化
	private static void lambdaHistory(List<Hero> heros) {
		System.out.println("使用匿名类的方式，筛选出 hp>100 && damange<50的英雄");
		// 匿名类的正常写法
		HeroChecker c1 = new HeroChecker() {
			@Override
			public boolean test(Hero h) {
				return (h.hp > 100 && h.armor < 50);
			}
		};
		filter(heros, c1);
		// 把new HeroChcekcer，方法名，方法返回类型信息去掉
		// 只保留方法参数和方法体
		// 参数和方法体之间加上符号 ->
		HeroChecker c2 = (Hero h) -> {
			return h.hp > 100 && h.armor < 50;
		};
		filter(heros, c2);
		
		// 把return和{}去掉
		HeroChecker c3 = (Hero h) -> h.hp > 100 && h.armor < 50;
		filter(heros, c3);
		
		// 把 参数类型和圆括号去掉
		HeroChecker c4 = h -> h.hp > 100 && h.armor < 50;
		filter(heros, c4);
		
		/*
		 * 最终版本：直接把表达式传递进去
		 */        
		filter(heros, h -> h.hp > 100 && h.armor < 50);
	}
    
    // lambda 引用静态方法
    private static void lambdaStaticFunction(List<Hero> heros) {
           
        HeroChecker c = new HeroChecker() {
            public boolean test(Hero h) {
                return h.hp>100 && h.armor<50;
            }
        };
          
        System.out.println("使用匿名类过滤");
        filter(heros, c);
        
        System.out.println("使用Lambda表达式");
        filter(heros, h->h.hp>100 && h.armor<50);
        
        System.out.println("在Lambda表达式中使用静态方法");
        filter(heros, h -> LambdaTest.testHero(h) );
        
        System.out.println("直接引用静态方法");
        filter(heros, LambdaTest::testHero);
    }
    
    // lambda 引用对象方法
    private static void lambdaObjectFunction(List<Hero> heros) {
    	System.out.println("Lambda表达式：");       
        filter(heros,h-> h.hp>100 && h.armor<50 );
 
        System.out.println("Lambda表达式中调用容器中的对象的matched方法：");       
        filter(heros,h-> h.matched() );
  
        System.out.println("引用容器中对象的方法 之过滤结果：");       
        filter(heros, Hero::matched);
    }
    
    // lambda 引用构造器
    private static void lambdaConstructor() {
    	Supplier<List> s = new Supplier<List>() {
    		public List get() {
    			return new ArrayList();
            }
        };
     
        //匿名类
        List list1 = getList(s);
         
        //Lambda表达式
        List list2 = getList(()->new ArrayList());
         
        //引用构造器
        List list3 = getList(ArrayList::new);
        prints(getType(list3));
    }
    public static List getList(Supplier<List> s){
        return s.get();
    }
    
    
    /*
	 *	练习	- Lambda表达式
	 *	把比较器-Comparator 章节中的代码，按照从匿名类演变成Lambda表达式的步骤，改写为Lambda表达式
	 */
	private static void work1(List<Hero> heros) {
		Collections.sort(heros, (h1,h2) -> h1.hp<=h2.hp ? 1 : -1 );
		System.out.println("按照血量排序后的集合：");
		System.out.println(heros);
	}
    
    /*
	 *	练习	- 引用静态方法
	 *	把比较器-Comparator 章节中的代码，使用引用静态方法的方式来实现
	 */
	private static void work2(List<Hero> heros) {
		Collections.sort(heros, LambdaTest::compare );
		System.out.println("练习	- 引用静态方法,	按照血量排序后的集合：");
		System.out.println(heros);
    }
    
    /*
   	 *	练习	- 引用对象方法
   	 *	把比较器-Comparator 章节中的代码，使用 引用容器中的对象的方法 的方式来实现。
   	 */
    private static void work3(List<Hero> heros) {
    	Collections.sort(heros,(h1,h2) -> h1.compare(h1,h2) );
    	System.out.println("练习	- 引用对象方法,	按照血量排序后的集合：");
    	System.out.println(heros);
    }
       
       /*
      	 *	练习	- 引用构造器
      	 *	把比较ArrayList和LinkedList的区别这段代码，改造成引用构造器的模式。
      	 *	目前的调用方式是: 
      	 *  	List<Integer> l;
      	 *     	l = new ArrayList<>();
      	 *     insertFirst(l, "ArrayList");
      	 *     l = new LinkedList<>();
      	 *     	 insertFirst(l, "LinkedList");
      	 * 改造后的调用方式将变为：
      	 *		insertFirst(ArrayList::new, "ArrayList");
      	 *		insertFirst(LinkedList::new, "LinkedList");
      	 */
    private static void work4(List<Hero> heros) {
    		
    }
    
    private static void filter(List<Hero> heros,HeroChecker checker) {
        for (Hero hero : heros) {
            if(checker.test(hero))
                System.out.print(hero);
        }
    }
    
    public static boolean testHero(Hero h) {
        return h.hp>100 && h.armor<50;
    }
    
    public static int compare(Hero h1, Hero h2) {
        //按照hp进行排序
        if(h1.hp>=h2.hp)
            return 1;  //正数表示h1比h2要大
        else
            return -1;
    }
}
