package interfaces;

import java.util.ArrayList;

import bookstore.Common;

public interface ICommon {
	String name = "";
	String description = "";
	int inventor = 0;
	String type = "";
	int quantity = 0;
	String status = "";
	double price = 0;
	double total = 0;
	String rentalPrice = "";
	String category = "";

	public void setName(String name);

	public String getName();

	public void setQuantity(int quantity);

	public int getQuantity();

	public void setInventory(int inventory);

	public int getInventory();

	public void setType(String type);

	public String getType();

	public void setDescription(String description);

	public String getDescription();

	public void setStatus(String status);

	public String getStatus();

	public void setPrice(double price);

	public double getPrice();

	public double calculateTotal(ArrayList<Common> products);

	public double getTax(double total);

	public void setRentalPrice(String rentalPrice);

	public String getRentalPrice();

	public String getCategory();

	public void setCategory(String category);

	public int getRented();

	public void setRented(int rented);

	public void setIsRented(boolean isRented);

	public boolean getIsRented();
}
