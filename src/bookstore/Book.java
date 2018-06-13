package bookstore;

import interfaces.ICDS;

public class Book extends Common {
	public String author;
	public int year;
	public Book() {
		this("", 1990);
	}
	public Book(String author, int year) {
		this.author = author;
		this.year = year;
	}
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
