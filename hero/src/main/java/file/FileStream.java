package main.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import main.java.util.Parents;

/*
 *	字节流操作文件
*/
public class FileStream extends Parents {
	
	
	public static void main(String[] ages) {
		
		try {
			File temp = new File("e:/JAVAStudy/hero/src/main/webapp/testFile/file.txt");
			
			/*
			 * 	字节流
			 *	输入：文件内容读取到内存
			 */
			FileInputStream fis = new FileInputStream(temp);
			byte[] all =new byte[(int) temp.length()];
            fis.read(all);
         
			/*
			 * 	输出：内容写入到文件
			*/
            File temp1 = newFile("e:/JAVAStudy/hero/src/main/webapp/testFile/test/test.txt");
            FileOutputStream fos = new FileOutputStream(temp1, true);
            String text = "鸡你太美";
            fos.write(text.getBytes());
            fos.write("\n\r".getBytes());
			
            /*
             * 	文件拆分为100k大小
			*/
//            File temp2 = newFile("e:/JAVAStudy/JaveTest/eclipse-inst-win64.exe");
//            fileSplit(temp2, 10000*1024, "ceshi");
            
            /*
             * 	将上述拆分的文件合并
			*/
            //File[] arr = newFile("e:/JAVAClass/ceshi").listFiles();
           // fileMerge("e:/JAVAStudy/JaveTest/ceshi", "LOL.exe");
            
            
//            File temp3 = new File("");
//            prints(temp3.getAbsolutePath());
            
			/* 
			 * 字节读取中文
			*/
            String a = new String(all, "UTF-8");
            prints(a);
            for(byte j : all) {
            	int i = j&0x000000ff;
            	prints(Integer.toHexString(i) + " 字节");
            }
//            File bytetTest = new File("e:/JAVAStudy/JaveTest/bytetTest.txt");
            byte[] by = {(byte)0xe6,(byte)0xb5,(byte)0x8b};
            String str = new String(by, "UTF-8");
            prints(str);
            byte[] byy = "这是测试".getBytes("UTF-8");

            for(byte b : byy) {
            	prints(b);
				/*//当值为负数时直接转换会做位扩展；
				 * 例如一个byte类型的-1（即0xff），会被转换成int 类型的-1（即0xffffffff），那么转化出的结果就不是我们想要的
				*/
            	int c = b&0x000000ff;
            	prints(b);
            	prints(Integer.toHexString(c));
            }
            
            //每次使用完流，都应该进行关闭
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
