package week03;

import java.util.Scanner;

public class Player {
	// �ʵ�� ����, �ʱ�ȭ�� ����� ��
	private Scanner sc; // Ű���� �Է�
	private String name; // ������ �̸�
	private String word; // �����ڰ� ���� �ܾ�
	
	public Player(String name) {
		this.name = name; // ������ �̸�
		sc = new Scanner(System.in); // scanner ��ü ����
	}
	
	public String getName() {return name;}
	
	// �����ڰ� ���� �ܾ� ��������
	public String getWordFromUser() {
		System.out.print(name + ">> ");
		word = sc.nextLine();
		return word;
	}
	
	// lastWord�� �����ڰ� ���� word�� ���Ͽ� �����ߴ��� �Ǵ�
	public boolean checkSuccess(String lastWord) {
		int lastIndex = lastWord.length() - 1; // lastWord�� �� ������ ���� �ε���
		// �����ڰ� ���� �ܾ�� lastWord�� �������� ������ ��
		if (lastWord.charAt(lastIndex) == word.charAt(0))
			return true;
		else
			return false;
	}

}
