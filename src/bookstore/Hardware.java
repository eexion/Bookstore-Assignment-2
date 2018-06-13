package bookstore;

import interfaces.ICDS;

public class Hardware extends Common {
	private String modelNumber;
	private String manufacturer;
	public Hardware() {
		this("","");
	}
	public Hardware(String modelNumber, String manufacturer) {
		this.modelNumber = modelNumber;
		this.manufacturer = manufacturer;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	
	public String getModelNumber() {
		return this.modelNumber;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getManufacturer() {
		return this.manufacturer;
	}
}
