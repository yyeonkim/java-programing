package quiz1;

public class Oval implements Shape {
	private int radius1;
	private int radius2;
	private String color;
	
	public Oval(int width, int height, String color) {
		this.radius1 = width / 2;
		this.radius2 = height / 2;
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println(radius1 * 2 + "x" + radius2 * 2 + "에 내접하는 타원입니다.");
	}

	@Override
	public double getArea() {
		return radius1 * radius2 * PI;
	}

	@Override
	public double getRound() {
		return 2 * PI * Math.pow(0.5 * (radius1 * radius1 + radius2 * radius2), 0.5);
	}

	@Override
	public String getColor() {
		return color;
	}

}

