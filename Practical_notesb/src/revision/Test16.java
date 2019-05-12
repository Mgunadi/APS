package revision;

import java.util.ArrayList;
import java.util.List;
class Foo {
public String toString() {
return "Foo" ;
}
}
public class Test16{
public static void main(String[] args ) {
List<Object> list = new ArrayList<Object>();
list .add( "Hello" );
Foo f = new Foo();
list .add( f );
String s = (String) list .get(1);
System. out .print( list .get(0) + "-" + f );
}
}