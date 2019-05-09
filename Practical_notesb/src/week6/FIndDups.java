package week6;

import java.util.*;

public class FIndDups {
    public static void main(String[] args) {


        Set s = new HashSet();


        for (Object a : args)
            if (!s.add(a))
                System.out.println("Duplicate detected: " + a);

        System.out.println(s.size() + " distinct words: " + s);
    }
}