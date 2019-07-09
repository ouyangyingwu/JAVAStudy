package main.java.exception;

/*	 银行异常类
*/
public class AccountException extends Exception {
	private double deficit;	 //透支额
	
	private static final long serialVersionUID = 1L;
	
	public AccountException(String message, double deficit) {
		super(message);
	}
	
	public double getDeficit() {
		return this.deficit;
	}
}
