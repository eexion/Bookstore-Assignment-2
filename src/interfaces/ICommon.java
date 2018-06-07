package interfaces;

import java.util.ArrayList;

import bookstore.Common;

public interface ICommon {
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
	
}
