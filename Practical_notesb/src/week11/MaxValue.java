package week11;

import java.util.Random;

public class MaxValue extends Thread{

	public MaxValue(int[] a){
		
	}
	
	public void run() {
		
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = {rand.nextInt(), rand.nextInt(), rand.nextInt(), rand.nextInt()};
		
		
		MaxValue M1 = new MaxValue(array);
		MaxValue M2 = new MaxValue(array);
		M1.start();
		M2.start();
		
	}

}

<<<<<<< HEAD
/*
 * class MaxValue1 extends Thread{ private int[] array = new int[4]; private
 * static int max = 0; private int currentNum, loopLimit;
 * 
 * public MaxValue1(int[] a) { this.array = a; }
 * 
 * private void pause(double seconds) { try { Thread.sleep(Math.round(1000.0 *
 * seconds)); } catch (InterruptedException ie) {
 * 
 * } }
 * 
 * public void run() {
 * 
 * // System.out.println(i); }
 * 
 * }
 */
=======
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
	


>>>>>>> 243bcf96b30a8d06b7eb78e0444f6b82a2d49e66

