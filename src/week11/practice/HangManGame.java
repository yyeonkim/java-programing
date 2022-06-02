package week11.practice;

import java.util.*;

public class HangManGame {
	private final int HIDDENCHAR = 2; // 숨기는 글자 개수
	private StringBuffer hiddenWord; // 숨긴 글자를 가진 단어
	private String newWord; // 게임을 위해 선정된 단어
	private Scanner sc; // 키 입력
	private int failCount; // 틀린 횟수
	
	public HangManGame() {
		sc = new Scanner(System.in);
	}
	
	// 선택된 단어 newWord에 2 개의 글자를 숨긴 단어 hiddenWord를 만든다.
	private void makeHidden() {
		hiddenWord = new StringBuffer(newWord);
		Random r = new Random();
		
		for (int k = 0; k < HIDDENCHAR; k++) {
			int index = r.nextInt(newWord.length());
			char c = newWord.charAt(index);
			
			for (int i = 0; i < newWord.length(); i++) {
				if (hiddenWord.charAt(i) == c)
					hiddenWord.setCharAt(i, '-');
			}
		}
	}
	
	private boolean complete(char key) {
		boolean hit = false;
		for (int i = 0; i < newWord.length(); i++) {
			if (hiddenWord.charAt(i) == '-' && newWord.charAt(i) == key) {
				hiddenWord.setCharAt(i, key);
				hit = true;
			}
		}
		if (!hit)
			failCount++;
		for (int i = 0; i < newWord.length(); i++) {
			if (hiddenWord.charAt(i) == '-')
				return false;
		}
		return true;
	}
	
	// 사용자 키를 입력받으면서 행맨 게임을 진행한다. 5번 틀리면 종료한다.
	// 한 단어 진행 후 y/n 물음에 대해 n을 입력하면 종료한다.
	private void go() {
		failCount = 0;
		char key;
		do {
			if (failCount == 5) {
				System.out.println("5번 실패 하였습니다.");
				break;
			}
			System.out.println(hiddenWord);
			System.out.print(">>");
			String text = sc.next();
			key = text.charAt(0);
		} while (complete(key));
		
		System.out.println(newWord);
	}
	
	// 게임 시작 메소드
	public void run() {
		System.out.println("지금부터 행맨 게임을 시작합니다.");
		Words words = new Words("C:\\Users\\82103\\Downloads\\words.txt");
		while(true) {
			newWord = words.getRandomWord();
			
			if (newWord == null) break;
			makeHidden(); // 2개의 글자를 숨긴 단어 만들기
			go(); // 게임 진행
			System.out.print("Next(y/n)?");
			String answer = sc.next();
			if (answer.equals("n")) break; // n을 입력하면 종료
		}
	}

	public static void main(String[] args) {
		HangManGame app = new HangManGame();
		app.run();


	}

}
