package main.java.helloWorld;

//import java.io.*;


public class HelloWorld {
    /* 第一个Java程序
     * 它将打印字符串 Hello World
     */
	//static String name;
	private static HelloWorld instance  = new HelloWorld();
	
	private HelloWorld() {	};
	
	public static HelloWorld getInstance() {
		return instance;
	}
	
    public static void main(String[] args) {
    	
    	System.out.println("Hello World and "+args);
        
        System.out.println("JAVA".toCharArray().length);
        
       }
}