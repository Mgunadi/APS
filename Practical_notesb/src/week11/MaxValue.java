package week11;

import java.util.Random;

public class MaxValue extends Thread{

	
	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = {rand.nextInt(), rand.nextInt(), rand.nextInt(), rand.nextInt()};
		
		
		MaxValue1 M = new MaxValue1(array);
		MaxValue1 N = new MaxValue1(array);
		M.start();
		N.start();
		
	}

}

class MaxValue1 extends Thread{
	private int[] array = new int[4];
	private static int max = 0;
	private int currentNum, loopLimit;
	
	public MaxValue1(int[] a) {
		this.array = a;
	}
	
	private void pause(double seconds) {
		try { 
			Thread.sleep(Math.round(1000.0 * seconds));
		} catch (InterruptedException ie) {

		}
	}
	
	public void run() {
		
			System.out.println("");
		}
	
	}
	



class MaxValue3 extends Thread{
	
}