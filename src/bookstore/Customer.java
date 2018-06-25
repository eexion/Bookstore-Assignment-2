package bookstore;

public class Customer {
	private String name;
	private int age;
	private String phone;
	private double amountSpent;
	
	public Customer() {
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}
	public double getAmountSpent() {
		return this.amountSpent;			
	}
}
