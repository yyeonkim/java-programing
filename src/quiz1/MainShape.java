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
		for (int i = 0; i < list.length; i++) System.out.println("������ " + list[i].getArea());
		System.out.println("---------------------------------------");
		for (int i = 0; i < list.length; i++) System.out.println("�ѷ��� " + list[i].getRound());
		System.out.println("---------------------------------------");
		for (int i = 0; i < list.length; i++) System.out.println("������ " + list[i].getColor());
		System.out.println("---------------------------------------");
		System.out.println("��ȭ���� ���װ������� 2076071 ��뿬");
		System.out.println("---------------------------------------");

	}

}
