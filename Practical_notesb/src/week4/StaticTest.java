package week4;

public class StaticTest {
	
	private static int objNum;  //Static Variable
    private String name;        //Instance Variable

    //Constructor:
    public StaticTest() {}
    
    //static methods:
    public static int getObjNum(){  
        return objNum;
    }
    
    public static void staticPrint(){
        System.out.println("Static Print");
    }

    //non-static methods:
    public String getName(){
        return name;
    }	
    
    public void objPrint(){
        System.out.println("Object Print");
    }
    
    public StaticTest(String name){
        objNum++;
        this.name = name;
    }

}
