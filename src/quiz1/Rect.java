package quiz1;

public class Rect implements Shape {
	private int width;
	private int height;
	private String color;
	
	public Rect(int w, int h, String color) { // ������, �ʵ�(����) �ʱ�ȭ
		this.width = w;
		this.height = h;
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println(width + "x" + height + " ũ���� �簢�� �Դϴ�.");
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
