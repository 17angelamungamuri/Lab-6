
public class Customer {

	public Customer(String first, String last, int age, int num) {
		String firstName = first;
		String lastName = last; 
		int theirAge = age; 
		int customerNum = num; 
	}

	public String getName(String first, String last) {
		return first+last;
	}
	
	public String displayInfo(String firstName,	String lastName, int theirAge, int customerNum) {
		return (firstName + " " + lastName + "/n" + theirAge + " years old /n" + "Customer number: " 
				+ customerNum);
	}
	public int getAge(int age) {
		return age;
	}
	public int getNum(int num) {
		return num;
	}
}
