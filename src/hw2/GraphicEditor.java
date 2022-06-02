package hw2;

import java.util.*;

public class GraphicEditor {
	private Scanner sc;
	private List<Shape> shapes = new ArrayList<>(); // ������ shape ����Ʈ
	private Shape Line;
	private Shape Rect;
	private Shape Circle;
	
	// ������
	public GraphicEditor() {
		sc = new Scanner(System.in);
		// �� shape object ����
		Line = new Line();
		Rect = new Rect();
		Circle = new Circle();
	}
	
	public void run() {
		int user; // ����ڰ� ������ ��ȣ
		System.out.println("�׷��� ������ beauty�� �����մϴ�.");
		
		while(true) {
			System.out.print("����(1), ����(2), ��� ����(3), ����(4) >> ");
			user = sc.nextInt();
			sc.nextLine();
			
			switch(user) {
				case 1: 
					System.out.print("Line(1), Rect(2), Circle(3) >> ");
					user = sc.nextInt();
					sc.nextLine();
					if(user == 1) {
						Line.setNext(new Line()); // next ����
						shapes.add(Line.getNext()); // ������ next�� ����Ʈ�� �߰�
					} else if (user == 2) {
						Rect.setNext(new Rect());
						shapes.add(Rect.getNext());
					} else if (user == 3) {
						Circle.setNext(new Circle());
						shapes.add(Circle.getNext());
					}
					continue;
					
				case 2:
					System.out.print("������ ������ ��ġ >> ");
					user = sc.nextInt();
					sc.nextLine();
					try {
						shapes.remove(user - 1); // ����Ʈ���� shape ����
					} catch (IndexOutOfBoundsException e) {  // ����Ʈ ���� ����� catch
						System.out.println("������ �� �����ϴ�.");
					}
					continue;
					
				case 3:
					int size = shapes.size();
					// ����Ʈ ���� ���� draw �Լ� ����
					for (int i = 0; i < size; i++) {
						Shape element = shapes.get(i);
						element.draw();
					}
					continue;
					
				case 4:
					System.out.println("Beauty�� �����մϴ�.");
					break;
				
				default: // ���⿡ ���� ���� ���� 
					System.out.println("�ٽ� �������ּ���.");
					continue;
			}
			break;
		}
	}

	public static void main(String[] args) {
		GraphicEditor beauty = new GraphicEditor();
		beauty.run();
	}

}
