package week11.practice;

import java.util.*;

public class HangManGame {
	private final int HIDDENCHAR = 2; // ����� ���� ����
	private StringBuffer hiddenWord; // ���� ���ڸ� ���� �ܾ�
	private String newWord; // ������ ���� ������ �ܾ�
	private Scanner sc; // Ű �Է�
	private int failCount; // Ʋ�� Ƚ��
	
	public HangManGame() {
		sc = new Scanner(System.in);
	}
	
	// ���õ� �ܾ� newWord�� 2 ���� ���ڸ� ���� �ܾ� hiddenWord�� �����.
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
	
	// ����� Ű�� �Է¹����鼭 ��� ������ �����Ѵ�. 5�� Ʋ���� �����Ѵ�.
	// �� �ܾ� ���� �� y/n ������ ���� n�� �Է��ϸ� �����Ѵ�.
	private void go() {
		failCount = 0;
		char key;
		do {
			if (failCount == 5) {
				System.out.println("5�� ���� �Ͽ����ϴ�.");
				break;
			}
			System.out.println(hiddenWord);
			System.out.print(">>");
			String text = sc.next();
			key = text.charAt(0);
		} while (complete(key));
		
		System.out.println(newWord);
	}
	
	// ���� ���� �޼ҵ�
	public void run() {
		System.out.println("���ݺ��� ��� ������ �����մϴ�.");
		Words words = new Words("C:\\Users\\82103\\Downloads\\words.txt");
		while(true) {
			newWord = words.getRandomWord();
			
			if (newWord == null) break;
			makeHidden(); // 2���� ���ڸ� ���� �ܾ� �����
			go(); // ���� ����
			System.out.print("Next(y/n)?");
			String answer = sc.next();
			if (answer.equals("n")) break; // n�� �Է��ϸ� ����
		}
	}

	public static void main(String[] args) {
		HangManGame app = new HangManGame();
		app.run();


	}

}
