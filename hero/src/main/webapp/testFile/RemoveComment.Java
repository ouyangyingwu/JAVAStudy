package main.java.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;

import main.java.util.Parents;

public class FileBuffered extends Parents {
	
	
	public static void main(String[] ages) {
		
		File temp = new File("e:/JAVAStudy/hero/src/main/webapp/testFile/test1.txt");
		try (
				FileReader fr = new FileReader(temp);
				BufferedReader br = new BufferedReader(fr);
				)
		{
			while (true) {
				String line = br.readLine();
                if (null == line)
                	break;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
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
		
		File f = new File("e:/JAVAStudy/hero/src/main/java/file/FileBuffered.Java");
		File f1 = new File("e:/JAVAStudy/hero/src/main/webapp/testFile/RemoveComment.Java");
		removeComments(f, f1);
	}
}
