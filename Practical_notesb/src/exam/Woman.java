package exam;

public class Woman extends Person implements Punch {

	private String name;
	
	public Woman(String name) {
		this.name = name; 
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		
		Woman mother = new Woman("Lily") { //needs to extend an existing class, in this case the class which houses the main method itself!
			public String daughter;
			public void getType() {
				System.out.println("I am a Mother.");;
			}
			public void PersonSays() {
				System.out.println("Mother speaks.");
			}
			public void slap() {
				System.out.println("Don't mess with a momma bear!");
			}
		};
		Woman bach = new Woman("Agatha");
		bach.getType();
		bach.PersonSays();
		bach.slap();
		mother.getType();
		mother.PersonSays();
		mother.slap();
	}
	
	public void getType() {
		System.out.println("I am a Woman.");
	}

	@Override
	public void PersonSays() {
		System.out.println("Generic Woman talks.");
		
	}

	@Override
	public void pow() {
		System.out.println("POW!!!");
		
	}

	@Override
	public void slap() {
		System.out.println("TCHHHK!");
		
	}
	
	
}