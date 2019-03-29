package week4;

public class Circle extends Shape{  
    private double radius;
    
    public Circle(double xPos, double yPos, double radius) {
        super(xPos, yPos);
        this.radius = radius;
    }
    
    public double computeArea() {
        return Math.PI * radius * radius; 
    }	 
    
    //public void draw(Color color){}
}