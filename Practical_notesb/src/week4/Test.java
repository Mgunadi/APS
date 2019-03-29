package week4;

public class Test {
	public static void main(String[] args) { 
		
		// difference between referencing for a static method and non-static method:
		StaticTest test = new StaticTest();
		
	    StaticTest.staticPrint();
	    test.staticPrint();    //test.objPrint() is OK.
	    
	    // WHat can static/ non-static methods access.
	    System.out.println(StaticTest.getObjNum());

        StaticTest a = new StaticTest("a");
        System.out.println(StaticTest.getObjNum());

        StaticTest b = new StaticTest("b");
        System.out.println(b.getObjNum());

        StaticTest c = new StaticTest("c");
        System.out.println(c.getObjNum());
	    
	}

}
