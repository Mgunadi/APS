package week5;

class AdultFrogBehaviour extends FrogBehaviour {

	public void swim() { 
		System.out.println("he adult frog is swimming in a frog style");
	   }

	@Override
	public FrogBehaviour changeBehaviour() {
		return this;
	}
}
