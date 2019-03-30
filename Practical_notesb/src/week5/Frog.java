package week5;

public class Frog {
    private FrogBehaviour behavior; 	// composition
    public Frog() { behavior = new TadpoleBehaviour(); }
    
    public void grow() { 		
      behavior = behavior.changeBehaviour(); // see if behaviour should change
      behavior.grow();	 		 
      behavior.swim();
   }
}
