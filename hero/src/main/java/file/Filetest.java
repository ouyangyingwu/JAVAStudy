package main.java.file;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

import main.java.util.Parents;

public class Filetest extends Parents {
	public static void main(String[] args) {
        // 绝对路径
        File f = new File("e:/JAVAStudy/hero/src/main/webapp/test/test.text");
        File f1 = new File("e:/JAVAStudy/hero/src/main/webapp/test");
        
        f.mkdirs();
        System.out.println("当前文件是：" +f);
        // 绝对路径
        System.out.println("当前文件的绝对路径：" +f.getAbsolutePath());
        //文件是否存在
        System.out.println("判断是否存在："+f.exists());
         
        //是否是文件夹
        System.out.println("判断是否是文件夹："+f.isDirectory());
          
        //是否是文件（非文件夹）
        System.out.println("判断是否是文件："+f.isFile());
          
        //文件长度
        System.out.println("获取文件的长度："+f.length());
          
        //文件最后修改时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long time = f.lastModified();
        Date d = new Date(time);
        System.out.println("获取文件的最后修改时间："+df.format(d));
        //设置文件修改时间为1970.1.1 08:00:00()
        f.setLastModified(0);
       
        // 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        String [] list = f1.list();
        for(String l : list) {
        	 prints("文件夹下有： "+ l );
        }
  
        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[]fs= f1.listFiles();
        for(File l : fs) {
       	 prints("文件夹下有::  "+ l.getName() );
       }
        
        // 以字符串形式返回获取所在文件夹
       prints( "所在文件夹"+f1.getParent());
  
        // 以文件形式返回获取所在文件夹
        f.getParentFile();
        // 创建文件夹，如果父文件夹skin不存在，创建就无效
        f1.mkdir();
  
        // 创建文件夹，如果父文件夹skin不存在，就会创建父文件夹
        f.mkdirs();
  
        // 创建一个空文件,如果父文件夹skin不存在，就会抛出异常
        //f.createNewFile();
        // 所以创建一个空文件之前，通常都会创建父目录
        //f.getParentFile().mkdirs();
  
        // 列出所有的盘符c: d: e: 等等
       prints(f.listRoots());
  
        // 刪除文件
        //f.delete();
  
        // JVM结束的时候，刪除文件，常用于临时文件的删除
        fs[0].deleteOnExit();
          
        //文件重命名
        File f2 = new File("e:/JAVAStudy/hero/src/main/webapp/test/test1.text");
        f.renameTo(f2);
        System.out.println("把LOL.exe改名成了DOTA.exe");
         
        System.out.println("注意： 需要在D:\\LOLFolder确实存在一个LOL.exe,\r\n才可以看到对应的文件长度、修改时间等信息");
        
        
        
        File temp = new File("C:\\WINDOWS");
        File[] arr = temp.listFiles();
        File max = null;
        File min = null;
        for(File t : arr) {
        	if(t.isFile()) {
        		prints("练习： "+ t.getName());
        		if( max == null || max.length() < t.length() )
            		max = t;
            	if( (min == null || min.length() > t.length()) && t.length()>0 )
            		min = t;
        	}
        }
        prints( "最大的文件是："+max.getName() +" 值为："+ max.length());
        prints( "最小的文件是："+min.getName() +" 值为："+ min.length());
        
        Filetest yy = new Filetest();
        File[] a = yy.myFlieList("e:/JAVAStudy/hero/src/main/java");
    }
	
	private File[] myFlieList ( String pathname ) {
		File[]	sum = new File[0];
		int test = 1;
		test++;
		//先将指定路径下的所有文件实例化
		File file = new File(pathname);
		//判断实例化的对象file是否存在，即指定路径是否存在
		if (!file.exists()) {
			//若file不存在，则抛出异常
			throw new IllegalArgumentException("目录" + pathname + "不存在");
		}
		//若文件存在，则将所有文件的实例化对象转化为数组形式
		File[] files = file.listFiles();
		//遍历文件数组
		for (File f : files) {
			//如果从数组中拿出来的值是File是文件类型，就直接先打印这个文件的路径名称
			System.out.println(f.getPath());
			//如果是拿出来的File是文件夹类型，就调用自己，利用递归的思想，即一层一层地打开
			if (f.isDirectory()) {
				//调用自己时候传入的参数为上一句判断出来的文件夹路径
				myFlieList(f.getAbsolutePath());
			}
		}
		return null;
	}
}
