package week05;

import java.util.*;

public class StackApp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int capacity; // 총 스택 저장 공간 크기
		
		while (true) {
			try {
				System.out.print("총 스택 저장 공간의 크기 입력 >> ");
				capacity = sc.nextInt();
				
			} catch (InputMismatchException e) {
				System.out.println("정수를 입력하세요.");
				sc.nextLine();
				continue;
			}
			sc.nextLine();
			break;
		}
		
		StringStack ss = new StringStack(capacity);
		
		while (true) {
			System.out.print("문자열 입력 >> ");
			String str = sc.nextLine();
			
			if (str.equals("그만")) break;
			
			boolean res = ss.push(str);
			
			if (!res) {
				System.out.println("스택이 꽉 차서 푸시 불가!");
			}
		}
		
		System.out.print("스택에 저장된 모든 문자열 팝: ");
		int length = ss.length();
		for (int i = 0; i < length; i++) {
			System.out.print(ss.pop() + " ");
		}
		System.out.println();
		
		sc.close();
	}

}
