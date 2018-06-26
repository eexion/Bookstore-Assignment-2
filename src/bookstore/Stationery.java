package bookstore;

public class Stationery extends Common {
	private String manufacturer;
	public Stationery(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Stationery() {
		this("");
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getManufacturer() {
		return this.manufacturer;
	} 
}
