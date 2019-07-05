package main.java.helloWorld;

import java.util.Arrays;

import main.java.util.Parents;

/*
 * 字符串练习
*/
public class StringArrayTest extends Parents {

	public static void main(String[] ages) { 
		//	创建一个长度为5的char数组
		String[] array = new String[8];
		char[] arr = new char[5];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 5; j++) {
				arr[j] =  (char)random();
			}
			//System.out.println( Arrays.toString(arr) );
			array[i] = new String(arr);
		}

        //System.out.println(Arrays.toString(array));
       // array = arraySort(array);
        
        String[] temp = {"test", "testText", "TAuyjhjk", "ooo", "46545132"};
        temp = arraySort(temp);
        System.out.println(Arrays.toString(temp));
	}
	
	/*
	 * 	递归法
	 * 	通过字符（数字字母）的ASCll码来获得随机字符
	 * 
	 * 	Math.random() 获得0-1的随机数，通过强制转换可以转为基本类型
	*/
	private static char random () {
		//	获得有效范围（包括数字字母）的ASCll吗的随机数,然后转换为 char 字符
		char i =  (char)(Math.random()*74 + 48);	
		//	判断得到的字符是否为数字或字母，是则返回，否则递归
		if(Character.isLetter( i ) || Character.isDigit( i ))
			return i;
		else 
			return random();
	}
	
}
