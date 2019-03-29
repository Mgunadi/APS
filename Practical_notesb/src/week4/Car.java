package week4;

public class Car extends Vehicle implements Drivable{
/*	private static String name;
	private static int numSold;
	
	public Car(String name, double price) {
		super(price);
		this.name = name;
	}
	
	public double sell(int quantity) {
		numSold += quantity;
		return get.Price * quantity;
	}
	
	public static int getNumSold(){
		System.out.println("The sold car is " + name);
	return numSold;
*/	
	
///// THE BELOW  REFERS TO THE INTERFACE IMPLEMENTATION EXAMPLE.////////////////////////////////////
	
	public Car(String name, double price) {
		super(price);
	}
	
    private double speed;
    private boolean keyOn;
       
    public void start(){
        speed = MINSPEED;
        keyOn = true;
    }
	   
    public void stop(){
        keyOn = false;
        speed = MINSPEED;
    }

    public double getSpeed(){return speed;}
	   
    public boolean accelerate(double rate, int sec){
        // something
        return true;
    }	   

    public boolean brake(double rate, int sec){
        // something
        return true;
    }
	
	
}
