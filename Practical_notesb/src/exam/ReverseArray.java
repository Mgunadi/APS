package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseArray <T> {

	private T[] array = null;
	private List <T> arrlist = new ArrayList<T>();
	
	public List<T> reverse(T[] array) {
		for (T elem: array) {
			arrlist.add(elem);
		}
		Collections.reverse(arrlist);
		return arrlist;
		
	}
	
	
	public static void main(String[] args) {
		List<Man> men = new ArrayList<Man>();
		men.add(new Man("Philip"));
		men.add(new Man("jonah"));
		men.add(new Man("Zack"));
		men.add(new Man("Wong"));
		
		Man[] men2 = {new Man("Philip"),new Man("jonah"),new Man("Zack")};
		
		ReverseArray trial = new ReverseArray();
		for (Object el: trial.reverse(men2)) {
			System.out.println(((Man)el).getName());
		}
		
		//ReverseArray.arrayListReverse(men2);
	}

	public List<T> arrayListReverse(T[] lst) {
	    ArrayList reversed= new ArrayList();
	    for (int i=lst.length-1;i>=0;i--){
	      T t = lst[i];
	      reversed.add(t);
	    }
	   return reversed;
	}
}
