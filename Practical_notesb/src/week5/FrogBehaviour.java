package week5;

abstract class FrogBehaviour {

	static int age = 0;
    public void grow() {age++;};
    abstract public void swim();
    abstract public FrogBehaviour changeBehaviour(); 
    
}
