package quiz1;

public class MainShape {

	public static void main(String[] args) {
		Shape[] list = new Shape[3];
		list[0] = new Circle(20, "RED");
		list[1] = new Oval(20, 60, "GREEN");
		list[2] = new Rect(20, 50, "BLUE");
		
		System.out.println("---------------------------------------");
		for (int i = 0; i < list.length; i++) list[i].redraw();
		System.out.println("---------------------------------------");
		for (int i = 0; i < list.length; i++) System.out.println("면적은 " + list[i].getArea());
		System.out.println("---------------------------------------");
		for (int i = 0; i < list.length; i++) System.out.println("둘레는 " + list[i].getRound());
		System.out.println("---------------------------------------");
		for (int i = 0; i < list.length; i++) System.out.println("색상은 " + list[i].getColor());
		System.out.println("---------------------------------------");
		System.out.println("이화여대 엘테공과대학 2076071 김용연");
		System.out.println("---------------------------------------");

	}

}
