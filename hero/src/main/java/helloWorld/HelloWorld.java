package main.java.helloWorld;

import main.java.leagueOfLegends.Hero;

//import java.io.*;


public class HelloWorld {
    /* 第一个Java程序
     * 它将打印字符串 Hello World
     */
	//static String name;
	
    public static void main(String[] args) {
    	Parent obj = new Parent("dandan");
    	System.out.println("Hello World and "+args);
        obj.print(" 0");
        
        Hero obj2 = new Hero();
        obj2.name = "盖伦";
        obj2.recovery(50);
        float hp = obj2.getHp();
        System.out.println("HP "+ hp +" obj2 "+ obj2.name);
       
        System.out.println("JAVA".toCharArray().length);
        
       }
}