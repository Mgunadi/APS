package week10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackgroundSorter extends Thread {

	List l;

	public BackgroundSorter(List l) {
		this.l = l;
	}

	public void run(){
		Collections.sort(l);
	}
	
	
	public static void main(String [] args) {
		ArrayList<String> list = new ArrayList<String>();
		Thread sorter = new BackgroundSorter(list);
		sorter.start();
	}
	
	
	
}