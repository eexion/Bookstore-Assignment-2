package bookstore;

import java.util.ArrayList;

import interfaces.*;

public class Common implements ICommon {
	private String name;
	private String description;
	private int inventory;
	private String type;
	private int quantity;
	private String status;
	private double price;
	private double total;
	private String rentalPrice;
	private String category;
	public boolean isRented;
	public int rented;
	private final static double TAX = 0.0;

	public Common() {
		this("", "", 0, "", 2, "", 0.0, "");
	}

	public Common(String name, String description, int inventory, String type, int quantity, String status,
			double price, String rentalPrice) {
		this.name = name;
		this.description = description;
		this.inventory = inventory;
		this.type = type;
		this.quantity = quantity;
		this.status = status;
		this.price = price;
		this.rentalPrice = rentalPrice;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setInventory(int inventory) {
		// TODO Auto-generated method stub
		this.inventory = inventory;
	}

	@Override
	public int getInventory() {
		// TODO Auto-generated method stub
		return this.inventory;
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		this.type = type;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public void setQuantity(int quantity) {
		// TODO Auto-generated method stub
		this.quantity = quantity;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return this.quantity;
	}

	@Override
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		this.status = status;
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return this.status;
	}

	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub
		this.price = price;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	@Override
	public double calculateTotal(ArrayList<Common> products) {
		// TODO Auto-generated method stub
		double totalBeforTax = 0.0;
		for (Common item : products) {
			totalBeforTax = totalBeforTax + (item.getPrice() * item.getQuantity());
		}
		this.total = totalBeforTax + getTax(totalBeforTax);
		return this.total;
	}

	@Override
	public double getTax(double total) {
		// TODO Auto-generated method stub
		double tax = total * TAX;
		return tax;
	}

	@Override
	public void setRentalPrice(String rentalPrice) {
		// TODO Auto-generated method stub
		this.rentalPrice = rentalPrice;
	}

	@Override
	public String getRentalPrice() {
		// TODO Auto-generated method stub
		return this.rentalPrice;
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return this.category;
	}

	@Override
	public void setCategory(String category) {
		// TODO Auto-generated method stub
		this.category = category;
	}

	@Override
	public boolean getIsRented() {
		return this.isRented;
	}

	@Override
	public void setIsRented(boolean isRented) {
		this.isRented = isRented;
	}
	@Override
	public int getRented() {
		return this.rented;
	}
	@Override
	public void setRented(int rented) {
		this.rented = rented;
	}
}