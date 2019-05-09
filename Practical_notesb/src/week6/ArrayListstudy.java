package week6;

import java.util.*;
public class ArrayListstudy {

	public static void iterator() {
	      // Create an array list
	      ArrayList al = new ArrayList();
	      
	      // add elements to the array list
	      al.add("C");
	      al.add("A");
	      al.add("E");
	      al.add("B");
	      al.add("D");
	      al.add("F");

	      // Use iterator to display contents of al
	      System.out.print("Original contents of al: ");
	      Iterator itr = al.iterator();
	      
	      while(itr.hasNext()) {
	         Object element = itr.next();
	         System.out.print(element + " ");
	      }
	      System.out.println();
	      
	      // Modify objects being iterated
	      ListIterator litr = al.listIterator();
	      
	      while(litr.hasNext()) {
	         Object element = litr.next();
	         litr.set(element + "+");
	      }
	      System.out.print("Modified contents of al: ");
	      itr = al.iterator();
	      
	      while(itr.hasNext()) {
	         Object element = itr.next();
	         System.out.print(element + " ");
	      }
	      System.out.println();

	      // Now, display the list backwards
	      System.out.print("Modified list backwards: ");
	      
	      while(litr.hasPrevious()) {
	         Object element = litr.previous();
	         System.out.print(element + " ");
	      }
	      System.out.println();
	}
	

	public static void compareForEach() {
		ArrayList s = new ArrayList();

        s.add("First Element");
        s.add("Second Element");
        s.add("Third Element");

        System.out.println("The set contains:");


        Object last = null;


        // iterate through the elements

        for (Object e : s) {
	     last = e;
           System.out.println(e);
        }

        // remove the last one!
        s.remove(last);

        System.out.println();
        System.out.println("The set now contains:");

        for (Object e : s)
		System.out.println(e);

        System.out.println("-End-");
	}
	
	
   public static void main(String args[]) {
	   iterator();
	   System.out.println();
	   compareForEach();
   }
}