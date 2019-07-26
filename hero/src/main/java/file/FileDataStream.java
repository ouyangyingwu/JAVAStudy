package main.java.file;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import main.java.util.Parents;

/*
 *	数据流操作文件
*/
public class FileDataStream extends Parents {
	
	
	public static void main(String[] ages) {
		
		File output = new File("e:/JAVAStudy/hero/src/main/webapp/testFile/fileData.txt");
		/*
		 * 写入
		 */	
		try (
				FileOutputStream fos = new FileOutputStream(output);
				DataOutputStream dos = new DataOutputStream(fos);
				)
		{
			dos.writeBoolean(false);
			dos.writeInt(666);
			dos.writeUTF("沧海一声笑");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		/*
		 * 读取
		 * 注意只有 DataOutputStream 类写入的文件才可以正确读取
		 */	
		try (
				FileInputStream fis = new FileInputStream(output);
				DataInputStream dis = new DataInputStream(fis);
				)
		{
			boolean b= dis.readBoolean();
            int i = dis.readInt();
            
            String str = dis.readUTF();
            prints("读取到布尔值: "+ b);
            prints("读取到整数: "+ i);
            prints("读取到字符串: "+ str);
			
        } catch (IOException e) {
            e.printStackTrace();
        }
		access(output);
	}
	
	/*
	 * 练习-向文件中写入两个数字，然后把这两个数字分别读取出来
	 * 
	 * 要求
	 * 第一种方式： 使用缓存流把两个数字以字符串的形式写到文件里，再用缓存流以字符串的形式读取出来，然后转换为两个数字。 
	 * 注： 两个数字之间要有分隔符用于区分这两个数字。 比如数字是31和15，如果不使用分隔符，那么就是3115，读取出来就无法识别到底是哪两个数字。 
	 * 使用分隔符31@15能解决这个问题。
	 * 
	 * 第二种方式： 使用数据流DataOutputStream向文件连续写入两个数字，然后用DataInpuStream连续读取两个数字
	*/
	private static void access(File file) {
		//缓存写入,可以用字符和字节流
		try(
				//FileOutputStream fos = new FileOutputStream(file);
				FileWriter fos = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fos);
				)
		{
			pw.print("31@15");
			pw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//缓存读取，只能用字节流
		try(
				//FileInputStream fr = new FileInputStream(file);	//不能使用字符流做为读取缓存的参数
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				)
		{
			while(true) {
				String line = br.readLine();
				if(line == null)
					break;
				String[] arr = line.split("@");
				prints(Arrays.toString(arr));
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//数据写入
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));){
			dos.writeInt(31);
			dos.writeChar('\n') ;    // 写入分隔符，这边是读取writechar()。
			dos.writeInt(15);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//数据读取
		try(	DataInputStream dis = new DataInputStream(new FileInputStream(file));	)
		{
			 int int1 = dis.readInt();    // 读取int
             dis.readChar() ; 			// 读取\t
             int int2 = dis.readInt();    // 读取int
             System.out.print(int1+"  "+int2);

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
