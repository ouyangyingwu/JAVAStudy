package main.java.exception;

import main.java.util.Parents;

/*	 银行账号
*/
public class Account extends Parents {
	protected double balance; //余额 
	
	// 获取余额
	public double getBalance() {
		return balance;
	}
	
	// 存钱
	public void deposit(double amt) {
		this.balance += amt;
	}
	
	//	取钱
	public void withdraw(double amt) throws AccountException {
		
		//AccountException a = new AccountException();
		if( (this.balance-amt) < 0 )
			throw new AccountException("你的额度不足", 0);
		this.balance -= amt;
	}
	
	//
	public Account(double balance){
		this.balance = balance;
	}
	
	public static void main(String[] agea) {
		Account temp = new Account(500d);
		try {
			temp.withdraw(2000);
		} catch(AccountException e) {
			System.out.println(e.getMessage());
            e.printStackTrace();
		}
		System.out.println("当前余额度为： "+ temp.balance );
	}
}
