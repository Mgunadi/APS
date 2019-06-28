package week11;

public class ReverseHello {
	public static void main(String[] args) {
		Thread t = new MyThread1(1);
		t.start();
	}
}

class MyThread1 extends Thread {
	private int count;
	
	public MyThread1(int count) {
		this.count = count;
	}
		
	@Override
	public void run() {
		if(count <= 5) {
			int c = count;
			Thread t = new MyThread1(++count);
			
			//calls a subprocess (eg. recursion)
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Hello from thread " + c);
		}
	}
}