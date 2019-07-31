package main.java.file;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import main.java.util.Parents;

/*
 *	缓存流操作文件
*/
public class MySystem extends Parents {
	
	
	public static void main(String[] args) {
        // 获得从控制台输入的数据
		Scanner s = new Scanner(System.in);
//       	while(true){
       		String line = s.nextLine();
       		System.out.println(line);
//       		if(line == "close") break;
//       }
       	s.close();
       	
       	//复制文件
       	File file1 = new File("src/main/java/file/Filetest.java");
    	File file2 = new File("src/main/webapp/testFile/copyFile.txt");
       	copyFile(file1, file2);
    	
       	//	复制文件夹
       	copyFolder("e:/JAVAStudy/JaveTest/t", "e:/JAVAStudy/JaveTest/ceshi");
       	
       	//	查找文件内容
       	String[] searchstr = search(new File("e:/JAVAStudy/JaveTest/t"), "捉迷藏");
       	prints(Arrays.toString(searchstr));
    }
}
