package bookstore;

public class CD {
		String title;
	    int duration;
	    String producer;
	    String genre;
	    int yearmade;
	    
	    public CD(){
	    	title="";
	    	duration=0;
	    	producer="";
	    	genre="";
	    	yearmade=0;	
	    } 
	    
	   public CD(String title,int duration,String producer,String genre,int yearmade){
		   this.title=title;
		   this.duration=duration;
		   this.producer=producer;
		   this.genre=genre;
		   this.yearmade=yearmade;
	   }
	   public void settitle(String title){
		   this.title=title;
	   }
	   public String gettitle(){
		   return title;
	   }
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
