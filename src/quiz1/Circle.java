package quiz1;

public class Circle implements Shape {
	private int radius;
	private String color;
	
	public Circle(int r, String color) {
		this.radius = r;
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println("반지름이 " + radius + "인 원입니다.");
	}

	@Override
	public double getArea() {
		return radius * radius * PI;
	}

	@Override
	public double getRound() {
		return 2 * radius * PI;
	}

	@Override
	public String getColor() {
		return color;
	}

}
