package main.java.helloWorld;

// 测试类
// 懒汉式单例模式改造
public class MyClass {
	private static MyClass instance;
	
	private MyClass() {	};
	
	public static MyClass getInstance() {
		if(instance == null) {
			instance = new MyClass();
		}
		return instance;
	}
	
	public static void main(String []args) {
		System.out.println("Hello World"); // 打印 Hello World
		for(int i=0;i<args.length;i++){
			System.out.println(args[i]); 
        } 
    }
}