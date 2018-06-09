package bookstore;

<<<<<<< HEAD
import interfaces.ICDS;

public class DVD extends Common implements ICDS{
	private double duration;
	  private  String producer;
	  private  String genre;
	  private  int yearmade;
	    
	    public DVD(){
	    	duration=0;
	    	producer="";
	    	genre="";
	    	yearmade=0;	
	    } 
	    
	   public DVD(String title,int duration,String producer,String genre,int yearmade){
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
=======
public class DVD extends Common  {
    private int duration;
   private  String director;
  private    String genre;
    int yearmade;
    
    public DVD(){
    	duration=0;
    	director="";
    	genre="";
    	yearmade=0;	
    } 
    
   public DVD(int duration,String director,String genre,int yearmade){
	   
	   this.duration=duration;
	   this.director=director;
	   this.genre=genre;
	   this.yearmade=yearmade;
   }
>>>>>>> 2950b5e971b2b10056683360ebc0140faa3370d1

   public void setduration(int duration){
	   this.duration=duration;
   }
   public int getduration(){
	   return duration;
   }
   public void setdirector(String director){
	   this.director=director;
   }
   public  String getdirector(){
	   return director;
   }
   public void setgenre(String genre){
	   this.genre=genre;
   }
   public String getgenre(){
	   return genre;
   }
   public void setyearmade(int yearmade){
	   this.yearmade=yearmade;
   }
   public int getyearmade(){
	   return yearmade;
   }
}

