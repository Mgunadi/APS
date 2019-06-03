package week11;

public class myThread extends Thread{

	public static void main(String[] args) {
		myThread t = new myThread();
		t.run();

	}
	
	public void run() {
		for(int i=1; i < 3; ++i)
			System.out.println(i + "..");
	}

}
