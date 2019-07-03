package main.java.helloWorld;

/*
 *	Generic 泛型
*/
public class Generic extends GenericParent {
	
	public static void main(String[] args) { 
		
		int i=1;
		
		String str = "";
		
		//打印变量类型为int
		prints(getType(i));
		
		// 调用父类的静态泛型方法
		prints(test3(i));
		
		// 调用父类的泛型方法
		Generic temp = new Generic();
		prints(temp.test5(str));
	}

	/*
	 * 	实现 GenericParent 类的抽象方法
	*/
	@Override
	public <T> T test1(T num) {
		// TODO Auto-generated method stub
		return num;
	}

	@Override
	public <T> void test2(T num) {
		// TODO Auto-generated method stub
		
	} 
	
	
}
