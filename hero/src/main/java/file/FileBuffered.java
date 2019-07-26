package main.java.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;

import main.java.util.Parents;

/*
 *	缓存流操作文件
*/
public class FileBuffered extends Parents {
	
	
	public static void main(String[] ages) {
		
		File temp = new File("e:/JAVAStudy/hero/src/main/webapp/testFile/test1.txt");
		/*
		 *	输入：文件内容读取到内存,使用缓存流读取数据
		 *
		 *	缓存流必须建立在一个存在的流(输入或输出)的基础上
		 *	流写在 try 内时，当try运行完或者运行catch、finally时会自动关闭
		 */	
		try (
				FileReader fr = new FileReader(temp);
				BufferedReader br = new BufferedReader(fr);
				)
		{
			while (true) {
				// 一次读一行
				String line = br.readLine();
                if (null == line)
                	break;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		/*
		 *	输出：内容写入到文件，使用缓存流存入数据
		 *
		 *	构造函数的第二个参数表示追加，否则会直接替换原有数据
		 *	println	会在后面自动换行
		 *	flush	会立即把数据写入到硬盘
		 */	
		try (
				FileWriter fr = new FileWriter(temp);
				PrintWriter pw = new PrintWriter(fr);
				)
		{
			pw.print("我在测试 PrintWriter \n");
			pw.flush();
			pw.println("我在测试 PrintWriter");
			pw.println("我在测试 PrintWriter");
			pw.println("我在测试 PrintWriter");
			pw.println("我在测试 PrintWriter");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		/*
		 *	作业：删除 // 注释的内容
		 */
		File f = new File("e:/JAVAStudy/hero/src/main/java/file/FileBuffered.Java");
		File f1 = new File("e:/JAVAStudy/hero/src/main/webapp/testFile/RemoveComment.Java");
		removeComments(f, f1);
	}
}
