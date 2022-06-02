package week05.practice3;

public class Circle extends Shape {
	protected String name;
	
	public void draw() {
		name = "Circle";
		System.out.println("Circle draw");
		super.name = "Shape";
		super.draw();
		System.out.println(name);
		System.out.println(super.name);
	}
	
	public static void main(String[] args) {
		Shape b = new Circle();
		b.paint();
	}
}
