package week4;

public class Shape_test {

 	Circle s1 = new Circle(0,0,5);
  	Square s2 = new Square(1,1,5);
    Shape  s3 = new Circle(2,2,5);
    Shape  s4 = new Square(3,3,5);
    //Shape  s5 = new Shape(4,4);   <-- ERROR!!
    
    public static void main(String[] args) { 
    	Shape[] s = new Shape[5];	
    	double[] areas = new double[5];
    	s[0] = new Circle(0,0,10);
    	s[1] = new Square(10,10,5);
    	s[2] = new Square(20,20,6);
    	s[3] = new Circle(30,30,7);   
    	s[4] = new Square(40,40,8);
    	
    	//dynamically bound
    	for (int i=0; i<5; i++) 
    		areas[i] = s[i].computeArea();

    	for (int i=0; i<5; i++) 
    		System.out.println(areas[i]);
    }
}
