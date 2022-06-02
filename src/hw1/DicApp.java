package hw1;

import java.util.*;

public class DicApp {
	private Scanner sc;
	private String korWord; // 사용자가 입력한 한글 단어
	private String engWord; // 사전에서 찾은 영어 단어
	
	public DicApp() {
		sc = new Scanner(System.in);
	}
	
	public void run() {
		System.out.println("한영 단어 검색 프로그램입니다.");
		
		while(true) {
			System.out.print("한글 단어? ");
			korWord = sc.nextLine();
			
			if (korWord.equals("그만")) break; // "그만" 입력하면 프로그램 종료
			
			engWord = Dictionary.kor2Eng(korWord);
			// 영어 단어를 찾지 못할 경우
			if (engWord == null) {
				System.out.println(korWord + "는(은) 저희 사전에 없습니다.");
				continue;
			}
			System.out.println(korWord + "는(은) " + engWord); // 영어 단어를 찾았을 경우
		}
		System.out.println("종료합니다...");
	}

	public static void main(String[] args) {
		DicApp dictionary = new DicApp();
		dictionary.run();
		
	}

}

