package week5;

public class Rectangle {

	  private int width;
	    private int height;
		
	    public int getWidth(){return width;}
	    public int getHeight(){return height;}

	    public Rectangle(int w, int h)
	        {width = w; height = h;}
		
	    public void draw(){/*some drawing method*/}
	    public int area(){return width * height;}
	    
}
