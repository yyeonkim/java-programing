package hw2;

import java.util.*;

public class GraphicEditor {
	private Scanner sc;
	private List<Shape> shapes = new ArrayList<>(); // 삽입한 shape 리스트
	private Shape Line;
	private Shape Rect;
	private Shape Circle;
	
	// 생성자
	public GraphicEditor() {
		sc = new Scanner(System.in);
		// 각 shape object 생성
		Line = new Line();
		Rect = new Rect();
		Circle = new Circle();
	}
	
	public void run() {
		int user; // 사용자가 선택한 번호
		System.out.println("그래픽 에디터 beauty을 실행합니다.");
		
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
			user = sc.nextInt();
			sc.nextLine();
			
			switch(user) {
				case 1: 
					System.out.print("Line(1), Rect(2), Circle(3) >> ");
					user = sc.nextInt();
					sc.nextLine();
					if(user == 1) {
						Line.setNext(new Line()); // next 설정
						shapes.add(Line.getNext()); // 가져온 next를 리스트에 추가
					} else if (user == 2) {
						Rect.setNext(new Rect());
						shapes.add(Rect.getNext());
					} else if (user == 3) {
						Circle.setNext(new Circle());
						shapes.add(Circle.getNext());
					}
					continue;
					
				case 2:
					System.out.print("삭제할 도형의 위치 >> ");
					user = sc.nextInt();
					sc.nextLine();
					try {
						shapes.remove(user - 1); // 리스트에서 shape 삭제
					} catch (IndexOutOfBoundsException e) {  // 리스트 범위 벗어나면 catch
						System.out.println("삭제할 수 없습니다.");
					}
					continue;
					
				case 3:
					int size = shapes.size();
					// 리스트 원소 별로 draw 함수 실행
					for (int i = 0; i < size; i++) {
						Shape element = shapes.get(i);
						element.draw();
					}
					continue;
					
				case 4:
					System.out.println("Beauty을 종료합니다.");
					break;
				
				default: // 보기에 없는 숫자 선택 
					System.out.println("다시 선택해주세요.");
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
