package revision;

import java.util.ArrayList;

public class GenericInheritance {
    public static void main(String[] args) {
        Library<Media> myMediaLib = new Library<Media>(); 
        Library<Book> myBookLib = new Library<Book>(); 
        //myBookLib.add(new Media()); //because myBooklib collection can only contain objects of Book class or any subclass of Book
        myBookLib.add(new Book()); //ok adding objects of Book class
        
        myMediaLib.add(new Media()); 
        myMediaLib.add(new Book());
        //the 2 lines above is ok because myMediaLib can only contain objects of class Media and subclasses of Media, which is Book
    }
}

class Media {}

class Book extends Media {}

class Library<E> {
    private ArrayList<E> resources = new ArrayList<E>();

    public void add(E x) // Allow any object of type E to be added
    {
        resources.add(x);
    }

    public E retrieveLast() { // Objects retrieved are type E
        int size = resources.size();
        if (size > 0) {
            return resources.get(size - 1);
        }
        return null;
    }
}

