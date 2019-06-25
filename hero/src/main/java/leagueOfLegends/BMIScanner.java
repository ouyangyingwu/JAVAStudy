package main.java.leagueOfLegends;

import java.util.Scanner; //获取用户输入

// 判断身体是否肥胖
public class BMIScanner {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
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
	
		scanner.close();	//关闭Scanner对象；
    }
}
