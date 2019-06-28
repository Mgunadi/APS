package exam;

public class Man extends Person {
	private String name;
	
	public Man(String name) {
		this.name = name; 
	}
	
	public String getName() {
		return name;
	}
	@Override
	public void PersonSays() {
		System.out.println("Generic man speaks.");
		
	}

}