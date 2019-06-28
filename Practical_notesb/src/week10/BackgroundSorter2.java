package week10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackgroundSorter2 implements Runnable {

	List l;

	public BackgroundSorter2(List l) {
		this.l = l;
	}

	public void run(){
		Collections.sort(l);
	}
	
	public static void main(String [] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		Runnable runSort = new BackgroundSorter2(list);
		Thread sorter = new Thread(runSort);
		sorter.start();
	}

}
