package main.java.exception;

public class MyStringBuffer implements IStringBuffer{
 
    int capacity = 16;
    int length = 0;
    char[] value;
    public MyStringBuffer(){
        value = new char[capacity];
    }
     
    //有参构造方法
    public MyStringBuffer(String str){
        this();
        if(null==str)
            return;
         
        if(capacity<str.length()){
            capacity  = value.length*2;
            value=new char[capacity];
        }
         
        if(capacity>=str.length())
            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
         
        length = str.length();
         
    }
     
    @Override
    public void append(String str) {
 
        insert(length,str);
    }
 
    @Override
    public void append(char c) {
        append(String.valueOf(c));
         
    }
 
    @Override
    public void insert(int pos, char b) {
        insert(pos,String.valueOf(b));
    }
 
    @Override
    public void delete(int start) {
         try {
        	 delete(start,length); 
         } catch(IndexException e) {
        	 System.out.println("异常的具体原因:"+e.getMessage());
             e.printStackTrace();
         }
    }
 
    //@Override
    public void delete(int start, int end) throws IndexException {
        //边界条件判断
        if(start<0)
            throw new IndexException("开始位置必须大于0");
         
        if(start>length)
        	throw new IndexException("开始位置必须小于length");
         
        if(end<0)
        	throw new IndexException("结束位置必须大于0");
         
        if(end>length)
        	throw new IndexException("结束位置必须小于length");
         
        if(start>=end)
        	throw new IndexException("开始位置必须大于结束位置");
         
        System.arraycopy(value, end, value, start, length- end);
        length-=end-start;
         
    }
 
    @Override
    public void reverse() {
 
        for (int i = 0; i < length/2; i++) {
             
            char temp = value[i];
            value[i] = value[length-i-1];
            value[length-i-1] = temp;
        }
         
    }
 
    @Override
    public int length() {
        // TODO Auto-generated method stub
        return length;
    }
 
    @Override
    public void insert(int pos, String b) {
 
        //边界条件判断
        if(pos<0)
            return;
         
        if(pos>length)
            return;
         
        if(null==b)
            return;
         
        //扩容
        while(length+b.length()>capacity){
            capacity = (int) ((length+b.length())*1.5f);
            char[] newValue = new char[capacity];
            System.arraycopy(value, 0, newValue, 0, length);
            value = newValue;
        }
         
        char[] cs = b.toCharArray();
         
        //先把已经存在的数据往后移
         
        System.arraycopy(value, pos, value,pos+ cs.length, length-pos);
        //把要插入的数据插入到指定位置
        System.arraycopy(cs, 0, value, pos, cs.length);
         
        length = length+cs.length;
         
    }
     
    public String toString(){
         
        char[] realValue = new char[length];
 
        System.arraycopy(value, 0, realValue, 0, length);
         
        return new String(realValue);
         
    }
     
    public static void main(String[] args) {
        MyStringBuffer sb = new MyStringBuffer("there light");
        System.out.println(sb);
        sb.insert(0, "let ");
        System.out.println(sb);
 
        sb.insert(10, "be ");
        System.out.println(sb);
        sb.insert(0, "God Say:");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.append('?');
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
         
        sb.reverse();
        System.out.println(sb);
        
        try {
        	sb.delete(0,0);
        } catch(IndexException e) {
        	System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println(sb);
        sb.delete(4);
        System.out.println(sb);
 
    }
}
