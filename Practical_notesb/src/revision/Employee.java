package revision;

public class Employee {
	String name ;  //must be visible to the class TestT
	
	public Employee(String name ) {
		this . name = name ;
	}
}
class TestT{
	public static void main(String[] JavaLatte) {
		Employee e = new Employee("JavaDeveloper");
		System. out .println( "Emp Name : " + e.name );
	}
}