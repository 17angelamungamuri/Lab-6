
public class Account {

	public Account(long acct, double balance, String first, String last) {
		
		long acctNum = acct; 
		double acctBalance = balance; 
		String firstName = first; 
		String lastName = last; 
	}
	
	public String getName(String first, String last) {
		return first+last;
	}
	
	public double addBalance(double balance, double amt) {
		return balance + amt; 
	}
	
	public double subBalance(double balance, double amt) {
		return balance - amt; 
	}
	
	public String getAcct(double balance) {
		return " " + balance + " ";
	}
	

}
