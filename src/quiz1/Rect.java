package quiz1;

public class Rect implements Shape {
	private int width;
	private int height;
	private String color;
	
	public Rect(int w, int h, String color) { // 생성자, 필드(변수) 초기화
		this.width = w;
		this.height = h;
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println(width + "x" + height + " 크기의 사각형 입니다.");
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getRound() {
		return 2 * (width + height);
	}

	@Override
	public String getColor() {
		return color;
	}

}
