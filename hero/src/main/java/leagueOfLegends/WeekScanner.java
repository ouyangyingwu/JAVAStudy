package main.java.leagueOfLegends;

import java.util.Scanner; //获取用户输入

// 判断手否为工作日
public class WeekScanner {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("今天星期几\n");
		int i = scanner.nextInt();
		int j = 3;
		if(i <= 0 || i > 7) {
		    while(j > 0) {
		        System.out.println("输入数据有误  " + "你还有" + j + "次机会");
				i = scanner.nextInt();
				if(i > 0 && i < 8) { break ; }
				j--;
				if(j == 0) {
					scanner.close();
				    System.out.println("输入数据有误   没有机会了");return;
				}
			}
		}
		System.out.printf("今天是%s ",(i > 5)?"周末":"工作日");
		scanner.close();	//关闭Scanner对象；
    }
}
