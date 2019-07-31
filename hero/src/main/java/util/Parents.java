package main.java.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 父类
 * 
 * 创建一些通用静态方法
 */
public class Parents {
	/**
	 * 获取变量类型方法 使用 类型的getClass()方法
	 */
	public static <T> String getType(T variable) {
		return variable.getClass().toString();
	}

	/**
	 * 升级版打印方法，参数可以是任意类型
	 */
	public static <T> void prints(T commetn) {
		System.out.println(commetn);
	}

	/**
	 * 比较两个字符串参数的排列是否正确 利用方法重载实现默认参数 判断传入的两个字符串顺序是否正确
	 * 
	 * 使用的系统函数： 
	 * <br>charAt(int n) String对象调用，将字符串的第n个字符取出来，参数为int型， 返回值为char类型
	 * <br>Character.toLowerCase('a) 直接使用，将字母转换为小写，参数为char类型，返回值为char类型
	 *
	 * @param str1 必填参数：比较得第一个值 
	 * @param str2 必填参数：比较得第二个值 必填参数 order：比较的方式，正序还是反序 
	 * @param capital 可选参数：是否区分大小写 可选参数 number：比较得起始值，从第几个字符开始比较
	 * 
	 * 	@return 返回值为：boolean类型
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

	/**
	 * 对字符串数组进行排序 利用方法重载实现默认
	 * 
	 * @param array 必填参数：任意类型的一维数组，用于排序的数组 
	 * @param sort 可选参数：boolean类型，排序方式，默认值为 true 表示正序排列
	 * @param order 可选参数：boolean类型，是否区分大小写，默认值为 true 区分
	 */
	protected static <T> T[] arraySort(T[] array) {
		return arraySort(array, true);
	}

	protected static <T> T[] arraySort(T[] array, boolean sort) {
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

	/**
	 * 返回一个指定长度的随机字符串数组
	 * 
	 * 使用的系统函数： 
	 * <br>Math.random() 直接调用，返回0-1之间的随机数，1取不到，无参数，返回值为 double 类型
	 * <br>Character.isLetter(i) 直接调用，判断字符是否为字母(a-zA-Z)，参数为char类型，返回boolean
	 * <br>Character.isDigit(i) 直接调用，判断字符是否为数字(0-9)，参数为char类型，返回boolean
	 * 
	 *	@param arrayLength 必填参数：要获得的数组的长度 
	 *	@param	stringLeng 必填参数：字符串的长度
	 * 
	 * @return 返回值： String[] 类型
	 */
	protected static String[] randomArr(int arrayLength, int stringLeng) {
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

	/**
	 * 递归法 通过字符（数字字母）的ASCll码来获得随机字符
	 * 
	 * 使用的系统函数： 
	 * <br>Math.random() 直接调用，返回0-1之间的随机数获得0-1的随机数，通过强制转换可以转为基本类型，1取不到，无参数，返回值为double类型
	 * <br>Character.isLetter(i) 直接调用，判断字符是否为字母(a-zA-Z)，参数为char类型，返回boolean
	 * <br>Character.isDigit(i) 直接调用，判断字符是否为数字(0-9)，参数为char类型，返回boolean
	 * 
	 * @return 返回值：char 类型字符
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

	/**
	 * 获取一个文件夹下的所有--文件---，包括子目录下的文件 利方法用重载来为递归添加一个外部对象
	 *
	 * <br>使用的系统函数：
	 * <br>isDirectory() File对象调用，判断对象是否为文件夹，无参数，返回值为Boolean类型
	 *
	 *@param pathname  必选参数：String类型，文件夹路径 
	 *@param list 可选参数 ：ArrayList<File>类型数组对象,重载方法设为了私有，在外部无法调用
	 *
	 * @return 返回值： ArrayList<File> 数组对象
	 */
	protected static ArrayList<File> listFileObj(String pathname) {
		return listFileObj(pathname, new ArrayList<File>());
	}

	private static ArrayList<File> listFileObj(String pathname, ArrayList<File> list) {
		File temp = new File(pathname);
		File[] tempArr = temp.listFiles();

		for (File f : tempArr) {
			if (f.isDirectory())
				listFileObj(f.getAbsolutePath(), list);
			else
				list.add(f);
		}
		return list;
	}

	/**
	 * 创建文件对象 如果传入的路径的文件夹不存在将会自动创建
	 *
	 * 使用的系统函数： 
	 * <br>getParentFile() File对象调用，以对象的形式返回当前文件所在的文件夹，无参数，返回值为File对象 
	 * <br>exists()	File对象调用，判断文件对象是否存在，无参数，返回值为 boolean 类型 
	 * <br>mkdirs() File对象调用，创建文件夹，如果父文件夹不存在就会创建父文件夹，无参数，无返回值
	 *
	 * @param pathname 必填参数：String类型，文件路径
	 *
	 * @return	返回值：File对象
	 */
	protected static File newFile(String pathname) {
		File temp1 = new File(pathname);
		File temp2 = temp1.getParentFile();
		if (!temp2.exists())
			temp2.mkdirs();
		return temp1;
	}

	/**
	 * 文件拆分 
	 * 将指定文件拆分为指定大小，文件必须存在
	 *
	 * @param	pathname  必填参数：String类型，文件路径 
	 * @param	size 必填参数 ：int类型，拆分后的文件大小
	 *
	 * @return	返回值：无
	 */
	protected static void fileSplit(String pathname, int size) {
		fileSplit(newFile(pathname), size);
	}
	/**
	 * 文件拆分 
	 * 将指定文件拆分为指定大小，文件必须存在
	 *	
	 *	<br>使用的系统函数： 
	 *	<br>getParentFile() File对象调用，以对象的形式返回当前文件所在的文件夹，无参数，返回值为File对象 
	 *	<br>exists() File对象调用，判断文件对象是否存在，无参数，返回值为 boolean 类型
	 *	<br>mkdirs() File对象调用，创建文件夹，如果父文件夹不存在就会创建父文件夹，无参数，无返回值
	 *
	 * @param	file 必填参数：File对象 
	 * @param	size 必填参数 ：int类型，拆分后的文件大小
	 *
	 * @return	返回值：无
	 */
	protected static void fileSplit(File file, int size) {
		fileSplit(file, size, "");
	}
	protected static void fileSplit(File file, int size, String folder) {
		try {
			if (!file.isFile())
				throw new IOException("这不是一个文件");

			FileInputStream temp = new FileInputStream(file);
			int len = (int) file.length();
			byte[] array = new byte[len];
			temp.read(array);
			int n = 0;
			for (int i = 0; i < len; i += size) {
				n++;
				String fileName = file.getAbsolutePath() + "-" + n;
				if(folder.length() > 0) 
					fileName = file.getParentFile().getAbsolutePath() +"/"+folder+"/"+file.getName() +"-" + n;
				
				FileOutputStream oneTemp = new FileOutputStream(newFile(fileName));
				byte[] arr = Arrays.copyOfRange(array, i, i + size);
				oneTemp.write(arr);
				oneTemp.close();
			}
			temp.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件合并 
	 * 将指定文件夹下的文件合并为一个指定名字的文件
	 *	
	 *	<br>使用的系统函数： 
	 *	<br>getParentFile() File对象调用，以对象的形式返回当前文件所在的文件夹，无参数，返回值为File对象 
	 *	<br>exists() File对象调用，判断文件对象是否存在，无参数，返回值为 boolean 类型
	 *	<br>mkdirs() File对象调用，创建文件夹，如果父文件夹不存在就会创建父文件夹，无参数，无返回值
	 *
	 * @param	pathname 必填参数：String类型，指定的文件的路径
	 * @param	fileName 必填参数 ：String类型，合并后的文件名称
	 * @param	fileArray 必填参数 ：File[]类型，需要合并的文件对象数组
	 * @param	newPathname 可选参数 ：String类型，合并后的文件的存放路径
	 *
	 * @return	返回值：无
	 */
	protected static void fileMerge(String pathname, String fileName) {
		File[] fileArray = newFile(pathname).listFiles();
		fileMerge(fileArray, fileName, pathname);
	}
	protected static void fileMerge(File[] fileArray, String fileName) {
		String pathname = fileArray[0].getParentFile().getAbsolutePath();
		fileMerge(fileArray, fileName, pathname);
	}
	protected static void fileMerge(String pathname, String fileName, String newPathname) {
		File[] fileArray = newFile(pathname).listFiles();
		fileMerge(fileArray, fileName, newPathname);
	}
	protected static void fileMerge(File[] fileArray, String fileName, String newPathname) {
		FileOutputStream obj = null;
		FileInputStream one = null;
		try {
			if(fileName.length() == 0) 
				throw new IOException("新文件名不能为空");
			
	        obj = new FileOutputStream(newPathname+"/"+fileName, true);
	        for(File i : fileArray) {
	        	one = new FileInputStream(i);
	        	byte[] tmp = new byte[(int)i.length()];
	        	one.read(tmp);
	        	obj.write(tmp);
	        	one.close();
	        }
	        obj.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(obj != null)	obj.close();
				if(one != null)	one.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *	文件加密
	 *	加密算法： 
	 *	数字：如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4，如果是9的数字，变成0；
	 *	字母字符：如果是非z字符，向右移动一个，比如d变成e, G变成H，如果是z，z->a, Z-A。字符需要保留大小写；
	 *	非字母字符：比如',&^ 保留不变，中文也保留不变；
	*/
	protected static void encodeFile(File encodingFile, File encodedFile) {
		char[] array = null;
		try (FileReader reader = new FileReader(encodingFile)){
			array = new char[(int) encodingFile.length()];
			reader.read(array);
			for(int i = 0; i < array.length; i++) {
				if(Character.isLetter(array[i])) {
					array[i] = Character.toLowerCase(array[i]) == 'z' ? (char)((int)array[i] - 25) : (char)((int)array[i] + 1);
				}
				if(Character.isDigit(array[i])) {
					array[i] = array[i] == '9' ? '0' : (char)((int)array[i] + 1);
				}
			}
		} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		try (FileWriter temp = new FileWriter(encodedFile, true)){
			temp.write(array);
		} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	/**
	 * 为文件去除注释(单行//、多行/* * /)
	 *	同一行有多个注释时会有问题
	*/
	protected static void removeComments(File file, File newfile) {
		try{
			if(!file.exists())
				throw new IOException("文件必须存在");
			if(file == newfile)
				throw new IOException("不能再原文件操作");
		} catch(IOException e) {
			e.printStackTrace();
		}
		try (
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(newfile);
				PrintWriter pw = new PrintWriter(fw);
				)
		{
			boolean multi = false;
			while (true) {
				String line = br.readLine();
                if (null == line)
					break;
                boolean show = true;
            	if(line.indexOf("//") == 0)
            		show = false;
            	if(line.indexOf("//") > 0) {
            		line = line.substring(0,line.indexOf("//"));
            		show = line.trim().length() > 0 ? true : false;
            	}
            	if(line.indexOf("/*") >= 0) {
            		int key = line.indexOf("/*");
            		multi = true;
            		if(key == 0)
            			show = false;
            		else {
            			line = line.substring(0, key);
            			show = line.trim().length() > 0 ? true : false;
            		}
            	}
            	if(multi) {
            		show = false;
               		int key = line.indexOf("*/");
               		if(key == line.length()-2) 
               			multi = false; 
               		if(key > 0) {
               			multi = false;
               			line = line.substring(key+2);
               			show = line.trim().length() > 0 ? true : false;
               		}
               }
                if(show)
                	pw.println(line);
            }
			pw.flush();
		}	catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
	 * 复制文件
	*/
	protected static void copyFile(String srcFile, String destFile){
		File file = new File(srcFile);
    	File newfile = new File(destFile);
    	copyFile(file,newfile);
	}
	protected static void copyFile(File file, File newfile){
		try(
				BufferedReader br = new BufferedReader(new FileReader(file));
				PrintWriter pw = new PrintWriter(new FileOutputStream(newfile));
				)
		{
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				pw.println(line);
			}
			pw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 复制文件夹，包括子文件和文件夹
	 * 
	 *	@param	srcFolder 必填参数：String类型，指定的文件夹的路径
	 * @param	destFolder 必填参数 ：String类型，复制后的文件夹的路径
	 * 
	 *	@return 返回值：无
	*/
	protected static void copyFolder(String srcFolder, String destFolder){
		File file = newFile(srcFolder);
    	File newfile = newFile(destFolder);
    	copyFolder(file,newfile);
	}
	/**
	 * 复制文件夹，包括子文件和文件夹
	 * 
	 * 使用的系统函数： 
	 *	<br>listFiles() File对象(对象需要是文件夹)调用，以File[]的形式返回当前文件夹下的文件对象(包括文件夹但是不包括子目录下的文件)，无参数， 返回值为File[]类型

	 *	@param	folder 必填参数 ：File类型，指定的被复制的文件夹对象
	 * @param	newFolder 必填参数 ：File类型，复制后的文件夹对象
	 * 
	 *	@return 返回值：无
	*/
	protected static void copyFolder(File folder, File newFolder){
		File[] fileArr = folder.listFiles();
		String newUrl = newFolder.getAbsolutePath();
		for(File i : fileArr) {
			File temp = newFile(newUrl+"/"+i.getName());
			if(i.isDirectory())
				copyFolder(i, temp);
			else
				copyFile(i, temp);
		}
	}
	
	/**
	 *	查找文件夹下的文件内容，包括子目录下的文件
	 *
	  * 使用的系统函数： 
	 * <br>listFiles() File对象(对象需要是文件夹)调用，以File[]的形式返回当前文件夹下的文件对象(包括文件夹但是不包括子目录下的文件)，无参数， 返回值为File[]类型
	 * <br>isDirectory()	File对象调用	，判断当前对象是否是文件夹，无参数，返回值为boolean类型
	 * <br>readLine()	BufferedReader对象调用，以字符串的形式返回文件一行内容最后返回null，无参数，返回值为String对象
	 * <br>getAbsolutePath()	File对象调用，以字符串形式返回当前文件对象的绝对路径，无参数，返回值为String对象
	 * <br>add()	ArrayList对象调用，将指定内容添加到当前数组中，参数为被添加的内容，无返回值
	 * <br>toArray()	ArrayList对象调用，将ArrayList数组转化为普通数组，参数为被转化后的对象，指定类型的普通数组
	 *
	 * @param	folder 必填参数 ：File类型，指定的被查找的文件夹对象
	 * @param	search 必填参数 ：String类型，需要查找的字符串
	 * 
	 *	@return 返回值：String[] 
	*/
	protected static String[] search(File folder, String search) {
		return search(folder, search, new ArrayList<String>());
	}
	private static String[] search(File folder, String search, ArrayList<String> list) {
		File[] fileArr = folder.listFiles();
		for(File i : fileArr) {
			if(i.isDirectory())
				search(i, search, list);
			else {
				try(BufferedReader br = new BufferedReader(new FileReader(i));)
				{
					while(true) {
						String line = br.readLine();
						if(line == null) break;
						if(line.indexOf(search) >= 0) {
							String url = i.getAbsolutePath();
							list.add(url);
							prints(url);
							break;
						}
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
//		String[] urlList =list.toArray(new String[list.size()]);
		String[] urlList = list.toArray(new String[] {});
		return urlList;
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
