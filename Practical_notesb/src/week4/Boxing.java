package week4;

public class Boxing {

	public static void main(String[] args) {
		
		//Boxing:
		Integer intObj = new Integer(95);
		Double doubleObj = new Double(3.14);
		Character charObj = new Character('A');

		
		//Unboxing:
		int i = intObj.intValue();
		double j = doubleObj.doubleValue();
		char k = charObj.charValue();
		
		//Automatic boxing:
		Integer intobj = 95;
		
		//Automatic unboxing:
		intObj = intObj + 15;
		System.out.println(intObj);
		
		//Static methods of the Wrapper classes:
		//intObj.MAX_VALUE;
	}

}