package main.java.exception;

/*	CheckingAccount 
*/
public class AccountChecking extends Account  {
	private double overdraftProtection;

	public AccountChecking(double balance) {
		super(balance);
	}
	
	public AccountChecking(double balance, double overdraftProtection) {
		super(balance);
		// TODO Auto-generated constructor stub
		this.overdraftProtection = overdraftProtection;
	}
	
	public void withdraw(double amt) throws AccountException {
		if(this.overdraftProtection < amt) {
			throw new AccountException("额度不足",  amt);
		}
		this.overdraftProtection -= amt;
	}
	
	public static void main(String[] ages) {
		AccountChecking a = new AccountChecking(33.6 , 7000d);
		prints(a.getBalance());
	}
}
