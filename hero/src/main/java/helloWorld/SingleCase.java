package main.java.helloWorld;

// 测试单例模式的类
public class SingleCase {
//	饿汉 单例 在声明类属性时初始化
//	 private static SingleCase instance = new SingleCase();  
	
//	懒汉 单例 在声明类属性时初始化
//	private static SingleCase instance ;
	
//	构造函数私有化
	private SingleCase(){}
	
//	通过 getInstance 方法返回对象
    public static SingleCase getInstance(){
//    	调用 饿汉 的单例模式
//    	return instance
    	
//    	调用 懒汉 的单例模式
//    	if(instance == null) {
//    		instance = new SingleCase();
//    	}
//    	return  instance;
    	
//    	调用 枚举 的单例模式
    	return Singleton.INSTANCE.getInstance();
    }
    
    
    private static enum Singleton{
        INSTANCE;
        
        private SingleCase singleton;
        //JVM会保证此方法绝对只调用一次
        private Singleton(){
            singleton = new SingleCase();
        }
        public SingleCase getInstance(){
            return singleton;
        }
    }
    
    public static void main(String[] args) {
    	SingleCase temp1 = SingleCase.getInstance();
    	SingleCase temp2 = SingleCase.getInstance();
    	
    	System.out.println("对象 temp1 == temp2 =  " + (temp1==temp2));
    }
}
