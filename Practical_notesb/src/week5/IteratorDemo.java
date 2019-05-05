package week5;
import java.util.*;
import java.util.Iterator; //Not really necessary

public class IteratorDemo
{
    public static void main(String[] args)
    {
        ArrayList s = new ArrayList();

        s.add("First Element");
        s.add("Second Element");
        s.add("Third Element");

        System.out.println("The set contains:");


        //return the iterator.
        Iterator i = s.iterator( );


        while (i.hasNext( ))
            System.out.println(i.next( ));

        //remove the current one - the last one!
        i.remove( );

        System.out.println( );
        System.out.println("The set now contains:");

        i = s.iterator( );
        while (i.hasNext( ))
            System.out.println(i.next( ));

        System.out.println("-End-");
    }
}