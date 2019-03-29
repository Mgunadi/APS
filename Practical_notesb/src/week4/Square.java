package week4;

public class Square extends Shape{  
    private double size;
    
    public Square(double xPos, double yPos, double size) {
        super(xPos,yPos);
        this.size = size;
    }
	
    public double computeArea() {
        return size * size; 
    }	 
    
    //public void draw(Color color){}
}