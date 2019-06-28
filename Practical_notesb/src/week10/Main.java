package week10;

import java.util.Collections;
import java.util.List;

public class Main {

	//creating a thread using an annonymous class.
	public static void main(String[] args) {
		List l = null;
		
		Thread sorter = new Thread(new Runnable(){
     	    public void run(){Collections.sort(l);}
		});

       sorter.start();
	}

}
