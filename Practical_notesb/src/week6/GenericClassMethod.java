package week6;

public class GenericClassMethod {

	public static void main(String[] args) {
		Sample<Integer> obj = new Sample<Integer>(42);
		obj.<String> show(new String("Hello"));
	}

}

class Sample<T> {
	private T data;
	
	public Sample(T data) {
		this.data = data;
	}
	
	public <ViewerType> void show(ViewerType viewer) {
		System.out.println("Viewer is: " + viewer);
		System.out.println("Data is: " + data);
	}
}

