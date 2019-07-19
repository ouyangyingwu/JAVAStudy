package main.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import main.java.util.Parents;

public class FileStream extends Parents {
	
	
	public static void main(String[] ages) {
		
		try {
			File temp = new File("e:/JAVAClass/file.txt");
			
			/*
			 * 	字节流
			 */
			//输入：文件内容读取到内存
			FileInputStream fis = new FileInputStream(temp);
			byte[] all =new byte[(int) temp.length()];
            fis.read(all);
            //输出：内容写入到文件
            File temp1 = newFile("e:/JAVAClass/t/e/s/t/test.txt");
            FileOutputStream fos = new FileOutputStream(temp1, true);
            String str = "shilezhi k  test 鸡你太美";
            fos.write(str.getBytes());
            fos.write("\n\r".getBytes());
			//文件拆分为100k大小
            File temp2 = newFile("e:/JAVAClass/eclipse-inst-win64.exe");
            fileSplit(temp2, 10000*1024, "ceshi");
            //将上述拆分的文件合并
            fileMerge("e:/JAVAClass/ceshi", "LOL.exe");
            
            /*
			 * 	字符流
			 */
            
            File temp3 = new File("");
            prints(temp3.getAbsolutePath());
            //每次使用完流，都应该进行关闭
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
