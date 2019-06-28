package week10;

public class TestCounter {
	public static void main(String[] args) {
		Counter c1 = new Counter(5);
		Counter c2 = new Counter(5);
		Counter c3 = new Counter(5);
		c1.start();
		c2.start();
		c3.start();
		//Three unsynchronized threads.
	}
}

class Counter extends Thread {
	private static int totalNum = 0;
	private int currentNum, loopLimit;

	public Counter(int loopLimit) {
		this.loopLimit = loopLimit;
		currentNum = totalNum++;
	}

	private void pause(double seconds) {
		try {
			Thread.sleep(Math.round(1000.0 * seconds));
		} catch (InterruptedException ie) {
	   }
	}

	/** When run finishes, the thread exits. */

	public void run() {
		for (int i = 0; i < loopLimit; i++) {
			System.out.println("Counter " + currentNum + ": " + i);
			pause(Math.random()); // Sleep for up to 1 second
		}
	}
}

