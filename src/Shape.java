import java.util.ArrayList;

public class Shape {
	public void draw() {
		System.out.println("//doSomething");
	}
	public static void main(String[] args) {
		ArrayList<Shape> list = new ArrayList<>();
		list.add(new Shape());
		list.get(0).draw();
	}
}
