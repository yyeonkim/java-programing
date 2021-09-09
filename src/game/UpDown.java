package game;

import java.util.*;

public class UpDown {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		// 사용자가 원하는 만큼 게임을 계속 실행한다.
		while (true) {
			int low = 0;
			int high = 99;
			int i = 1; // 시도 횟수
			int card = r.nextInt(100); // 카드에 적힌 값 (정답)
			
			System.out.println("수를 결정했습니다. 맞춰 보세요.");
			
			// 정답을 맞힐 때까지 계속 실행한다.
			while (true) {
				int answer; // 사용자가 대답한 수
				
				System.out.printf("%d-%d\n", low, high);
				System.out.printf("%d >> ", i);
				
				// 사용자가 문자를 입력하면 예외 처리
				try { 
					answer = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("정수를 입력하세요.");
					sc.nextLine(); // 문자 버리기
					continue;
				}	
				
				if (card == answer) {  // 정답이면
					break;
				} else if (card > answer) {  // 정답보다 숫자가 작으면
					System.out.println("더 높게");
					i++; // 시도 횟수 증가s
					low = answer;
					continue;
				} else {  // 정답보다 숫자가 크면
					System.out.println("더 낮게");
					i++;  // 시도 횟수 증가
					high = answer;
					continue;
				}
			}
			
			System.out.printf("%d번 시행 후 맞췄습니다. 다시하시겠습니까?(y/n) ", i);
			char c = sc.next().charAt(0);
			
			if (c == 'n') break;
			else if (c == 'y');
			else {  // n, y 외에 다른 값 입력 시 그냥 종료한다.
				System.out.println("잘못된 문자입니다.");
				break;
			}
		}
		
		System.out.println("게임을 종료합니다.");
		sc.close();
	}

}
