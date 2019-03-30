package week5;

public class Window_comp {

	private int border; 
    private String title;
    private Rectangle rectangle;


    public Window_comp(Rectangle r){
        rectangle = r;
    }


    public void draw() {
        rectangle.draw();
        // draw something else
    }
    public void area() { rectangle.area();}

}
