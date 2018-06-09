package bookstore;

import interfaces.ICDS;

public class CD extends Common implements ICDS{
	  private double duration;
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
