package week4;

public abstract class Shape {
    private double xPosition;
    private double yPosition;
   
    public Shape(double xPos, double yPos){
        xPosition = xPos;
        yPosition = yPos;
    }
   
    public abstract double computeArea(); 	 
    //public abstract void draw(Color color); 	 
	
    public double getXPos(){return xPosition;}
    public double getYPos(){return yPosition;}
}
