package week03;

import java.util.*;

public class WordGameApp {
	// 필드(변수) 생성
	private Scanner sc; // 키보드 입력
	private String startWord = "아버지"; // 시작 단어
	private Player[] players; // 게임 참가자
	
	// 생성자 메소드
	public WordGameApp() {
		sc = new Scanner(System.in);
	}
	
	// 참가자 수 입력받고 Player[] 배열을 생성하는 메소드
	private void createPlayers() {
		int nPlayers = 0; // Player 수
		while(true) {
			System.out.print("게임에 참가하는 인원은 몇 명입니까? >> ");
			// 문자 입력 시 예외 처리
			try {
				nPlayers = sc.nextInt();
			} catch (InputMismatchException e) { // 정수가 아닌 문자를 입력했을 경우
				sc.nextLine();
				System.out.println("정수를 입력하세요.");
				continue;
			}
			break;
		}
		sc.nextLine();
		players = new Player[nPlayers]; // 명수 만큼 Player 배열 할당
		// 각 참여자 이름을 입력받아 Player 객체 생성
		for (int i = 0; i < nPlayers; i++) {
			System.out.print("참가자의 이름을 입력하세요 >> ");
			String name = sc.nextLine();
			players[i] = new Player(name); // 객체 생성
		}
	}
	
	// 게임을 진행하는 메소드
	public void run() {
		System.out.println("끝말잇기 게임을 시작합니다...");
		createPlayers(); // 참가자를 위한 Player[]을 생성한다.
		String lastWord = startWord; // startWord에서 부터 시작한다.
		System.out.println("시작하는 단어는 " + lastWord + "입니다.");
		int next = 0; // 현재 player index
		// 게임이 끝날 때까지 루프
		while (true) {
			// next 참가자가 단어를 말하도록 한다. 말한 단어를 newWord에 저장.
			String newWord = players[next].getWordFromUser(); 
			// next 참가자가 성공하였는지 검사
			if (!players[next].checkSuccess(lastWord)) { 
				System.out.print(players[next].getName() + "이(가) 졌습니다.");
				break; // 게임 종료
			}
			next++; // 다음 참가자
			next %= players.length; // next가 참가자의 개수보다 많게 증가하는 것을 막는다. 참가자 내에서 반복된다.
			lastWord = newWord; // 참가자가 말한 단어를 lastWord로 지정
		}
		
	}
	
	// main은 클래스로 분리하기
	public static void main(String[] args) { 
		WordGameApp game = new WordGameApp(); // 생성자 객체 (코드 보안 효과)
		game.run();

	}

}
