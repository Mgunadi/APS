package revision;

class Base {
public final int getNext( int i ) {
return ++ i ;
}
}

class Derived extends Base {
//public int getNext( int i ) {
//return i ++;
//}
}

public class Test14 {
public static void main(String[] args ) {
int result = new Derived().getNext(3);
System. out .print( result );
result = new Base().getNext(3);
System. out .print( result );
}
}
