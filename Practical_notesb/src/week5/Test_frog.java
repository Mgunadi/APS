package week5;

public class Test_frog {
	public static void main(String[] args)
	   {  Frog afrog = new Frog();
	    	
	    	for (int week = 0; week < 25; week ++)
	    	{   System.out.print(week + " ");
	    	    afrog.grow();	
	      }
	   }
}
