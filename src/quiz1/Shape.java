package quiz1;

interface Shape {
	final double PI = 3.14;
	void draw();
	double getArea();
	double getRound();
	String getColor();
	
	default public void redraw() {
		System.out.print("--- �ٽ� �׸��ϴ�. ");
		draw();
	}
}
