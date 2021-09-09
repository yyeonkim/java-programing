package game;

import java.util.Scanner;

public class GameRSPMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요.");
		System.out.print("이화 >> "); 
		String ewha = sc.next();  // 이화 문자열 입력받기
		System.out.print("컴공 >> ");
		String computer = sc.next();  // 컴공 문자열 입력받기
		
		String result = "";
		
		// 서로 값이 동일 할 때
		if (ewha.equals(computer)) 
			result = "비겼습니다.";
		
		// 이화가 가위일 때
		if (ewha.equals("가위")) {
			if (computer.equals("보"))
				result = "이화가 이겼습니다.";
			else if (computer.equals("바위")) 
				result = "컴공이 이겼습니다.";
		}
		// 이화가 바위일 때
		if (ewha.equals("바위")) {
			if (computer.equals("가위"))
				result = "이화가 이겼습니다.";
			else if (computer.equals("보")) 
				result = "컴공이 이겼습니다.";	
		}
		// 이화가 보일 때
		if (ewha.equals("보")) {
			if (computer.equals("바위"))
				result = "이화가 이겼습니다.";
			else if (computer.equals("가위")) 
				result = "컴공이 이겼습니다.";
		}
		
		System.out.println(result);
		sc.close();
	}

}
