package main.java.util;

/*
 * 	父类
 * 	
 *	创建一些通用静态方法
*/
public class Parents {
	/*
	 *	获取变量类型方法
	 *	使用 类型的getClass()方法
	*/
	public static <T> String getType(T variable){
		return variable.getClass().toString();
	}

	/*
	 *	升级版打印方法，参数可以是任意类型
	*/
	public static <T> void prints(T commetn){ 
		System.out.println(commetn);
	}
	
	/*
	 * 	比较两个字符串参数的排列是否正确
	 * 利用方法重载实现默认参数
	 * 	判断传入的两个字符串顺序是否正确
	*/
	protected static boolean stringJuxtapose(String str1 , String str2, boolean order) {
		// 方法重载添加参数 capital(是否区分大小)，默认值为false(区分)
		return stringJuxtapose(str1 , str2, order, false);
	}
	protected static boolean stringJuxtapose(String str1 , String str2, boolean order, boolean capital) {
		// 方法重载添加参数 number，默认值为0（从第下标为0的字符开始比较）
		return stringJuxtapose(str1 , str2, order, capital, 0);
	}
	
	private static boolean stringJuxtapose(String str1 , String str2, boolean order, boolean capital, int number) {
		char lastChari =  str1.charAt(number);
		char lastCharj =  str2.charAt(number);

		if(!capital) {
			lastChari = Character.toLowerCase(lastChari);
			lastCharj = Character.toLowerCase(lastCharj);
		}
		
		if(lastChari == lastCharj) {
			number++;
			if(number < str1.length() && number < str2.length())
				 return stringJuxtapose(str1 , str2, order, capital, number); 
			if( order )
				return str1.length() < str2.length() ? true : false;
			else 
				return str1.length() > str2.length() ? true : false;
		} else {
			if( order )
				return lastChari < lastCharj ? true : false;
			else 
				return lastChari > lastCharj ? true : false;
		}
	}
	
	/*
	 * 	对字符串数组进行排序
	 * 
	 * 	 利用方法重载实现默认参数,	默认为正序排列
	*/
	protected static <T> T[] arraySort (T[] array) {
		return arraySort(array , true);
	}
	protected static <T> T[] arraySort (T[] array,boolean order) {
		int len = array.length; 
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if(stringJuxtapose((String)array[i] , (String)array[j], order)) {
					T temp = array[i]; 
					array[i] = array[j];
					array[j]	  = temp;
				}
			}
		}
		return array;
	}
}
