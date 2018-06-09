package bookstore;

<<<<<<< HEAD
import interfaces.ICDS;

public class CD extends Common implements ICDS{
	  private double duration;
=======
public class CD extends Common {
	  private int duration;
>>>>>>> 2950b5e971b2b10056683360ebc0140faa3370d1
	  private  String producer;
	  private  String genre;
	  private  int yearmade;
	    
	    public CD(){
	    	duration=0;
	    	producer="";
	    	genre="";
	    	yearmade=0;	
	    } 
	    
	   public CD(String title,int duration,String producer,String genre,int yearmade){
		   this.duration=duration;
		   this.producer=producer;
		   this.genre=genre;
		   this.yearmade=yearmade;
	   }
<<<<<<< HEAD
	@Override
	public String getProducer() {
		// TODO Auto-generated method stub
		return this.producer;
	}

	@Override
	public void setProducer(String producer) {
		// TODO Auto-generated method stub
		this.producer = producer;
	}

	@Override
	public int getYear() {
		// TODO Auto-generated method stub
		return this.yearmade;
	}

	@Override
	public void setYear(int yearmade) {
		// TODO Auto-generated method stub
		this.yearmade = yearmade;
	}

	@Override
	public String getGenre() {
		// TODO Auto-generated method stub
		return this.genre;
	}

	@Override
	public void setGenre(String genre) {
		// TODO Auto-generated method stub
		this.genre = genre;
	}

	@Override
	public double getDuration() {
		// TODO Auto-generated method stub
		return this.duration;
	}

	@Override
	public void setDuration(double duration) {
		// TODO Auto-generated method stub
		this.duration = duration;
	}
	
}
=======
	
	   public void setduration(int duration){
		   this.duration=duration;
	   }
	   public int getduration(){
		   return duration;
	   }
	   public void setproducer(String producer){
		   this.producer=producer;
	   }
	   public  String getproducer(){
		   return producer;
	   }
	   public void setgenre(String genre){
		   this.genre=genre;
	   }
	   public String genre(){
		   return genre;
	   }
	   public void setyearmade(int yearmade){
		   this.yearmade=yearmade;
	   }
	   public int getyearmade(){
		   return yearmade;
	   }
	}
>>>>>>> 2950b5e971b2b10056683360ebc0140faa3370d1
