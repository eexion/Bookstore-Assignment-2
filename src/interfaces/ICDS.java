package interfaces;

public interface ICDS {
	double duration = 0;
	String producer = "";
	String genre = "";
	int yearmade = 0;

	public String getProducer();

	public void setProducer(String producer);

	public int getYear();

	public void setYear(int year);

	public String getGenre();

	public void setGenre(String genre);

	public double getDuration();

	public void setDuration(double duration);
}
