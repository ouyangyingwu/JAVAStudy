package main.java.leagueOfLegends;

import java.util.Scanner; //获取用户输入

// 判断是否为闰年
public class LeapYearScanner {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("请输入年份\n");
	 
		int year = scanner.nextInt();
		
		if(year > 0 && ((year%4 == 0 && year%100 > 0) || year%400 == 0 )) 	System.out.println(year +" 是闰年");
		else System.out.println(year +" 不是闰年");
		
		scanner.close();	//关闭Scanner对象；
    }
	
	public static void leapYear() {
		System.out.println(" 请输入你要进行的功能：");
		System.out.println(" 1.判断年份是否为闰年 请输入：年份");
		System.out.println(" 2.判断是否为工作日 请输入：星期");
		System.out.println(" 3.判断你的BMI值 请输入：BMI");
	}
}
