package bookstore;

import interfaces.ICDS;

public class Software extends Common {
	public String author;
	public int year;
	public Software() {
		this("",1990);
	}
	public Software(String author, int year) {
		this.author = author;
		this.year = year;
	}
	public String getAuthor() {
		// TODO Auto-generated method stub
		return this.author;
	}

	public void setAuthor(String author) {
		// TODO Auto-generated method stub
		this.author = author;
	}
	public int getYear() {
		// TODO Auto-generated method stub
		return this.year;
	}
	public void setYear(int year) {
		// TODO Auto-generated method stub
		this.year = year;
	}

}
