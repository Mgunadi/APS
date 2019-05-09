package week6;
import java.util.*;

public class GenericLibrary {
	   public static void main(String args[]) {
		   
	      Library<Book> myBooks =  new Library<Book>();
	      myBooks.add(new Book());
	      myBooks.add(new Book());
	      Book lastBook = myBooks.retrieveLast();
	      lastBook.print();     

	      Library<Video> myVideos =  new Library<Video>();
	      myVideos.add(new Video());
	      myVideos.add(new Video());
	      Video lastVideo = myVideos.retrieveLast();
	      lastVideo.print();     
        }
}

// Using parameterized type
class Library<E> 
{
   private ArrayList<E> resources = new ArrayList<E>();
 
   public void add(E x) //Allow any object of type E to be added
   {
      resources.add(x);
   }

   public E retrieveLast() { //Objects retrieved are type E
      int size = resources.size();
      if (size > 0) {
         return resources.get(size-1);
      }
      return null;
   }
}

class Book{
	public void print(){
		System.out.println("Book Printed");
	}
}
class Video{
	public void print(){
		System.out.println("Video printed");
	}
}

