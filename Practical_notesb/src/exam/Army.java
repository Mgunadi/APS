package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Army <T extends Person>{  //generic class

	private T[] conscriptlist;
	private List<String> names = new ArrayList<String>();
	
	
	public Army(T[] list) {
		this.conscriptlist = list;
		for (int i = 0 ; i < conscriptlist.length ; i++) {
			if (conscriptlist[i] instanceof Man) {
				names.add(((Man)conscriptlist[i]).getName());
			} else if (conscriptlist[i] instanceof Woman) {
				names.add(((Woman)conscriptlist[i]).getName());
			}
		}
	}
	
	
	public void getOfficers ( List<? super Gentleman> Officers ) {
		System.out.println(((Man)Officers.get(0)).getName());
	}
	
	public void FirstRegister() {
		Collections.sort(names); //sort only works if it is List not ArrayList
		System.out.println(names);
		
	}
	
	public static void main(String[] args) {
		Person[] US = {new Man("Zeke"), new Woman("Uliana"), new Man("Phillips")};
		Army USA = new Army(US);
		USA.FirstRegister();
		
		List<Man> Officers = new ArrayList<Man>();
		Officers.add(new Man("Stuart"));
		USA.getOfficers(Officers);
		

		Man[] Officers2 = {new Man("Zeus")};
		// Army<? super String> a = new 
		//usually the bounded wildcard is used during instantiating the objects. But you cannot provided boundaries that do not match the initial class definition.
		Army<? super Gentleman> a2;
		a2 = new Army(Officers2);
		a2.FirstRegister();
		//a3 = new Army(Officers);
		
		
	}

}
