package week4;

public interface Drivable {
	public double MINSPEED = 0;
	public double MAXSPEED = 150;
	// Same as public static final double MAXSPEED

	   public void    start();
	   public void    stop();
	   public double  getSpeed();
	   public boolean accelerate(double rate, int sec);
	   public boolean brake(double rate, int sec); 

	   // Same as public abstract boolean brake(..);
}
