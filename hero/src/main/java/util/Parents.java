package main.java.util;

import java.io.File;
import java.util.ArrayList;

/*
 * 	父类
 * 	
 *	创建一些通用静态方法
*/
public class Parents {
	/*
	 * 获取变量类型方法 使用 类型的getClass()方法
	 */
	public static <T> String getType(T variable) {
		return variable.getClass().toString();
	}

	/*
	 * 升级版打印方法，参数可以是任意类型
	 */
	public static <T> void prints(T commetn) {
		System.out.println(commetn);
	}

	/*
	 * 比较两个字符串参数的排列是否正确 利用方法重载实现默认参数 判断传入的两个字符串顺序是否正确
	 */
	protected static boolean stringJuxtapose(String str1, String str2, boolean order) {
		// 方法重载添加参数 capital(是否区分大小)，默认值为false(不区分)
		return stringJuxtapose(str1, str2, order, false);
	}

	protected static boolean stringJuxtapose(String str1, String str2, boolean order, boolean capital) {
		// 方法重载添加参数 number，默认值为0（从第下标为0的字符开始比较）
		return stringJuxtapose(str1, str2, order, capital, 0);
	}

	private static boolean stringJuxtapose(String str1, String str2, boolean order, boolean capital, int number) {
		char lastChari = str1.charAt(number);
		char lastCharj = str2.charAt(number);

		if (!capital) {
			lastChari = Character.toLowerCase(lastChari);
			lastCharj = Character.toLowerCase(lastCharj);
		}

		if (lastChari == lastCharj) {
			number++;
			if (number < str1.length() && number < str2.length())
				return stringJuxtapose(str1, str2, order, capital, number);
			if (order)
				return str1.length() < str2.length() ? true : false;
			else
				return str1.length() > str2.length() ? true : false;
		} else {
			if (order)
				return lastChari < lastCharj ? true : false;
			else
				return lastChari > lastCharj ? true : false;
		}
	}

	/*
	 * 对字符串数组进行排序
	 * 
	 * 利用方法重载实现默认 参数 sort 区分字母大小写, 默认值 true 区分 参数 order 正反序, 默认值 true 为正序排列
	 */
	protected static <T> T[] arraySort(T[] array) {
		// 正反序，默认为 true 正序
		return arraySort(array, true);
	}

	protected static <T> T[] arraySort(T[] array, boolean sort) {
		// 区分大小写，默认为 true 区分
		return arraySort(array, sort, true);
	}

	protected static <T> T[] arraySort(T[] array, boolean sort, boolean order) {
		int len = array.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (stringJuxtapose((String) array[i], (String) array[j], sort, order)) {
					T temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	/*
	 * 返回一个指定长度的随机字符串数组
	 */
	protected static String[] randomArr(int arrayLength, int stringLeng, String type) {
		String[] array = new String[arrayLength];

		char[] arr = new char[stringLeng];
		for (int i = 0; i < arrayLength; i++) {
			/*
			 * 方法一 运用递归去除无用(符号)值
			 */
			for (int j = 0; j < stringLeng; j++) {
				arr[j] = (char) random();
			}
			/*
			 * 方法二 for 循环的一种新写法
			 */
			for (int j = 0; j < stringLeng;) {
				char x = (char) ((int) (Math.random() * ((int) 'z' - (int) '0')) + '0');
				if (Character.isDigit(x) || Character.isLetter(x)) {
					arr[j] = x;
					j++;
				}
			}
			array[i] = new String(arr);
		}
		return array;
	}

	/*
	 * 递归法 通过字符（数字字母）的ASCll码来获得随机字符
	 * 
	 * Math.random() 获得0-1的随机数，通过强制转换可以转为基本类型
	 */
	private static char random() {
		// 获得有效范围（包括数字字母）的ASCll吗的随机数,然后转换为 char 字符(48-122的随机数)
		char i = (char) (Math.random() * (122 - 48) + 48);
		// 判断得到的字符是否为数字或字母，是则返回，否则递归
		if (Character.isLetter(i) || Character.isDigit(i))
			return i;
		else
			return random();
	}

	/*
	 * 获取一个文件夹下的所有--文件---，包括子目录下的文件
	 *	
	 *	利方法用重载来为递归添加一个外部对象
	 */
	protected static ArrayList<File> listFileObj(String pathname) {
		return listFileObj(pathname , new ArrayList<File>());
	}
	private static ArrayList<File> listFileObj(String pathname, ArrayList<File> list) {
		File temp = new File(pathname);
		File[] tempArr = temp.listFiles();
		
		for(File f : tempArr) {
			if (f.isDirectory())
				listFileObj( f.getAbsolutePath(),list);
			else
				list.add(f );
		}
		return list;
	}

	public static void main(String[] ages) {
		ArrayList<File> list = listFileObj("e:/JAVAStudy/hero/src/main/java");
		File[] array = (File[]) list.toArray(new File[list.size()]);
		prints(list.get(2).getName());
		prints(array[2].getName());
		prints( list);
		prints( array);
	}
}
