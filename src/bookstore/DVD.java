package bookstore;

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

