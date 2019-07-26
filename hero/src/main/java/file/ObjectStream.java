package main.java.file;

import main.java.leagueOfLegends.charactor.Hero;
//import main.java.leagueOfLegends.charactor.ADHero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import main.java.util.Parents;

/*
 *	对象流
 *	对象流只能基于用字节流
 *	把一个对象序列化有一个前提是：这个对象的类，必须实现了Serializable接口
*/
public class ObjectStream extends Parents {
	
	
	public static void main(String[] ages) {
		Hero garen = new Hero("盖伦", 615f, 14f, 330);
		//	可以使用相对路径 src/main/webapp/testFile/garen.lol
		File hero = new File("e:/JAVAStudy/hero/src/main/webapp/testFile/garen.lol");

		try (
				/*
				 *	输出：对象序列化后保存到文件中去
				 */	
				FileOutputStream fos = new FileOutputStream(hero);
				ObjectOutputStream os = new ObjectOutputStream(fos);
				/*
				 *	输入：对象序列化后保存到文件中去
				 */	
				FileInputStream fis = new FileInputStream(hero);
	            ObjectInputStream ois =new ObjectInputStream(fis);
				)
		{
			os.writeObject(garen);
			Hero h2 = (Hero) ois.readObject();
			prints(h2.name);
        } catch (IOException  e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exercise();
	}
	
	/*
	 * 练习-序列化数组
	 * 
	 * 准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组
	 * 然后把该数组序列化到一个文件heros.lol
	 * 接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样
	*/
	private static void exercise() {
		Hero[] heroArray = new Hero[10];
		for(int i = 0; i < 10 ; i++) {
			heroArray[i] = new Hero("盖伦 "+(i+1)+" 号", 615f, 14f, 330);
		}
		File file = new File("e:/JAVAStudy/hero/src/main/webapp/testFile/garenArray.lol");
		try( 
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				)
		{
			os.writeObject(heroArray);
			Hero[] arr = (Hero[])ois.readObject();
			for(Hero i : arr) {
				prints(i.name);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
