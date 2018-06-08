package bookstore;

public class DVD  {
	String title;
    int duration;
    String director;
    String genre;
    int yearmade;
    
    public DVD(){
    	title="";
    	duration=0;
    	director="";
    	genre="";
    	yearmade=0;	
    } 
    
   public DVD(String title,int duration,String director,String genre,int yearmade){
	   this.title=title;
	   this.duration=duration;
	   this.director=director;
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
   public void setdirector(String director){
	   this.director=director;
   }
   public  String getdirectior(){
	   return director;
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

