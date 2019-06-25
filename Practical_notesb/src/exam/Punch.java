package exam;

public interface Punch {

	static final double strength = 6;  //not public by default.
	public double speed = 7;   // by default it is static and final.
	
	public abstract void pow();  
	public void slap();  //by default it is abstract
	
	
	
}
