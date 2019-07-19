package main.java.file;

import java.io.File;
import java.util.ArrayList;
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
        
        ArrayList<File> a = listFileObj("e:/JAVAStudy/hero/src/main/java");
        
    }
}
