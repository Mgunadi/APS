package week10;

import java.applet.*;

public class ThreadApplet extends Applet implements Runnable {
	Thread subThread;

	public void start() {
		if (subThread == null)
			subThread = new Thread(this);
		subThread.start();
	}

	public void run() {
		System.out.println("This is the subthread");
		System.out.println("inside the Applet");
	}

	public void init() {
		// standard applet initialisation here
		// no need to worry about the subthread
	}
}

