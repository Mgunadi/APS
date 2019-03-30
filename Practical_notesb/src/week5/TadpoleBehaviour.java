package week5;

class TadpoleBehaviour extends FrogBehaviour {

	   public void swim() {
		      System.out.println("The tadpole is swimming in a tadpole style");
		   } 
	   	 @Override
		 public FrogBehaviour changeBehaviour() { 
		      if (age > 18) return new AdultFrogBehaviour(); 
		      else return this; 
		   }

	
}
