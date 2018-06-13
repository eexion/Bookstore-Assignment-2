package bookstore;

public class Stationary extends Common {
	private String manufacturer;
	public Stationary(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Stationary() {
		this("");
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getManufacturer() {
		return this.manufacturer;
	} 
}
