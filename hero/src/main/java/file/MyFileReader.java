package main.java.file;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

import main.java.util.Parents;

/*
 *	字符流操作文件
*/
public class MyFileReader extends Parents {
	
	
	public static void main(String[] ages) {
		
		File temp = new File("e:/JAVAStudy/JaveTest/file.txt");
		/*
		 *	输入：文件内容读取到内存
		 *
		 *	流写在 try 内时，当try运行完或者运行catch、finally时会自动关闭
		 */	
		try (FileReader fis = new FileReader(temp)){
			char[] all = new char[(int) temp.length()];
			fis.read(all);
			
			
			prints(String.copyValueOf(all));        
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		/*
		 *	输出：内容写入到文件
		 *
		 *	构造函数的第二个参数表示追加，否则会直接替换原有数据
		 */	
		try (FileWriter fis = new FileWriter(temp, true)){
			String str = "鸡你太美\n";
			char[] all = str.toCharArray();
			fis.write(str);
			fis.write(all);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		File temp1 = new File("e:/JAVAStudy/JaveTest/temp.txt");
		encodeFile(temp1 , temp1);
	}
}
