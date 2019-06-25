package main.java.leagueOfLegends;

import java.util.Scanner; //获取用户输入
import java.util.Arrays;


public class ScannerOperating {
    final String test;

    public ScannerOperating(String test) {
        this.test = test;
    }

    public void test1(){
        final String test;
        test = "test";
    }

	public static void main(String[] args) {
		operatingText();
		Scanner scanner = new Scanner(System.in);
		goldPoint();
		String operating = scanner.nextLine();
		
		if(operating.length() > 0){
			//operatingAlert(String operating, scanner);
		}
		scanner.close();	//关闭Scanner对象；
    }
	
	private static void operatingText() {
		System.out.println(" 请输入你要进行的功能：");
		System.out.println(" 1.判断年份是否为闰年 请输入：年");
		System.out.println(" 2.判断是否为工作日 请输入：星期");
		System.out.println(" 3.判断你的BMI值 请输入：BMI");
		System.out.println(" 4.判断你输入的月份的季节 请输入：月");
	}
	
	private static void operatingAlert(String operating, Scanner scanner) {
		switch(operating) {
		case "年": leapYear(scanner) ;break;
		case "星期": week(scanner) ;break;
		case "BMI": bmi(scanner) ;break;
		case "月": month(scanner) ;break;
		case "阶乘": whileTest(scanner) ;break;
		default:
            System.out.println("这个是什么鬼？");
		}
	}
	
	private static void leapYear(Scanner scanner) {
		System.out.println("请输入年份\n");
		int year = scanner.nextInt();
		
		if(year > 0 && ((year%4 == 0 && year%100 > 0) || year%400 == 0 )) 	System.out.println(year +" 是闰年");
		else System.out.println(year +" 不是闰年");
	}
	
	private static void week(Scanner scanner) {
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
	}
	
	private static void bmi(Scanner scanner) {
		System.out.println("请输入你的身高\n");
		float height = scanner.nextFloat();
		height = height/100;
		if(height > 0) {
			System.out.println("请输入你的体重\n");
			float weight = scanner.nextFloat();
			if(height > 0 && weight > 0) {
				float bmi = weight/(height*height);
				String status;
				if(bmi < 18.5) status = "体重过轻";
				else if(bmi < 24) status = "正常范围";
				else if(bmi < 27) status = "体重过重";
				else if(bmi < 30) status = "轻度肥胖";
				else if(bmi < 35) status = "中度肥胖";
				else if(bmi >= 35 ) status = "重度肥胖";
				else status = "数据错误";
				
				System.out.println("当前的身体状态是：" +status+ " IBM值为: " + bmi);
			}
		}
	}
	
	private static void month(Scanner scanner) {
		
	}
	//while 练习
	private static void whileTest(Scanner scanner) {
		System.out.println("请输入一个整数：");
		int year = scanner.nextInt();
		int oldYear = year;
		int number = 1;
		/* 因为0的阶乘为1所以不能使用do while
		 * do { number *= year; year--; }while(year > 1);
		 */ 
		while(year > 1) { 
			number *= year; year--;
		};
		System.out.println(oldYear +" 的阶乘是："+ number);
	}
	//for 联系
	private static void money(Scanner scanner) {
		System.out.println("请输入一个整数：");
		int y = scanner.nextInt();
		
		int number = 0;
		for(int i = 1; i <= y; i++) {
			int m = (int)Math.pow(2, i-1);
			System.out.println(" 洪乞丐第 "+ i +" 天，收入是："+ m);
			number += m;
		}
		
		System.out.println(" 洪乞丐干 "+ y +" 天，收入是："+ number);
	}
	
	// 打印 1-100 之间的数，如果这个数，要么是3，要么5的倍数，就忽略掉
	private static void multiple(Scanner scanner) {
		System.out.println("请输入一个整数：");
		int m = scanner.nextInt();
		
		int number = 0;
		for(int i = 1; i <= m; i++) {
			if( i%3 == 0 || i%5 == 0) {
				continue;
			}
			System.out.println( i );
		}
	}
	/*
	 * 每年投入1w2 利润20% 需要多少年后收入可达到100w
	 * 复利公式：
	 * F = p* ( (1+r)^n );
	 * F 最终收入
	 * p 本金
	 * r 年利率
	 * n 存了多少年
	 */
	private static void interest() {
		
		double f;
		double p = 12000;
		float r = 0.2f;
		int n = 1;
		for(int i = n; ; i++) {
			f = p*(1+r);
			p = f + 12000;
			System.out.println( "这是第 "+ i +" 年，总收入为: "+ p +"; 投资金额为 "+ 12000*i);
			if(f >= 1000000) break;
		}
	}
	// 1-20内两个数相除，其结果 离黄金分割点 0.618最近的一组数; 不能能同时为偶数
	private static void goldPoint() {
		int size = 100;
		int v = 0;
		float[] arr = new float[size];
		String[] str = new String[size];

		System.out.println( "数组arr "+Arrays.asList(arr));
		for(int i=1; i<=20; i++) {
			for(int j=1; j<=20; j++) {
				if(i >= j ||(i%2==0 && j%2==0)) continue;
				
				float num= (float)((float)i/j - 0.618);
				
				// num = (float)Math.abs(num);
				num = num > 0 ? num : -num;
				System.out.println( "值 "+num);
				if(v == size) {
					size++;
					float[] array = new float[size];
					String[] strin = new String[size];
					System.arraycopy(arr, 0, array, 0, v);
					System.arraycopy(str, 0, strin, 0, v);
					//System.out.println( "数组copy "+Arrays.toString(array));
					arr = array;
					str = strin;
				}
				System.out.println( "数组长度 "+size);
				arr[v] = num;
				str[v] = i+"，"+j;
				v++;
			}
		}
		
		System.out.println( "数组 "+Arrays.toString(arr));
		int minIndex=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]<arr[minIndex]) minIndex=i;
		}
		System.out.println( "数组最小值为:  "+minIndex);
		String[] ratio = str[minIndex].split("，");
		System.out.println( "数组ratio:  "+Arrays.toString(ratio));
		
		int ii = Integer.parseInt(ratio[0]);
		int jj = Integer.parseInt(ratio[1]);
		
		// 代码优化
		float min = 1;	int minI=0; 	int minJ=0;
		for(int i=1; i<=20; i++) {
			for(int j=1; j<=20; j++) {
				if(i >= j ||(i%2==0 && j%2==0)) continue;
				
				float num= (float)((float)i/j - 0.618);
				num  = num > 0 ? num : -num;
				if(min > num) {
					min = num;
					minI = i;
					minJ = j;
				}
			}
		}
		
		System.out.println( "分子为： "+minI+"， 分母为："+minJ+" 的比值为："+(float)minI/minJ+" 最接近0.618；");
		System.out.println( "分子为： "+ii+"， 分母为："+jj+" 的比值为："+(float)ii/jj+" 最接近0.618；");
	}
}
