package main.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileStream {
	
	
	public static void main(String[] ages) throws FileNotFoundException {
		
		try {
			File temp = new File("e:/JAVAClass/file.txt");
			FileInputStream fis = new FileInputStream(temp);
			
			byte[] all =new byte[(int) temp.length()];
            //以字节流的形式读取文件所有内容
            fis.read(all);
            for (byte b : all) {
                //打印出来是65 66
                System.out.println(b);
            }
            
            //每次使用完流，都应该进行关闭
            fis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}
}
