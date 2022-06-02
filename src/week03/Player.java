package week03;

import java.util.Scanner;

public class Player {
	// 필드는 선언만, 초기화는 사용할 때
	private Scanner sc; // 키보드 입력
	private String name; // 참가자 이름
	private String word; // 참가자가 말한 단어
	
	public Player(String name) {
		this.name = name; // 참가자 이름
		sc = new Scanner(System.in); // scanner 객체 생성
	}
	
	public String getName() {return name;}
	
	// 참가자가 말한 단어 가져오기
	public String getWordFromUser() {
		System.out.print(name + ">> ");
		word = sc.nextLine();
		return word;
	}
	
	// lastWord와 참가자가 말한 word를 비교하여 성공했는지 판단
	public boolean checkSuccess(String lastWord) {
		int lastIndex = lastWord.length() - 1; // lastWord의 맨 마지막 문자 인덱스
		// 참가자가 말한 단어와 lastWord의 마지막이 같은지 비교
		if (lastWord.charAt(lastIndex) == word.charAt(0))
			return true;
		else
			return false;
	}

}
