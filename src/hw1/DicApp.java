package hw1;

import java.util.*;

public class DicApp {
	private Scanner sc;
	private String korWord; // ����ڰ� �Է��� �ѱ� �ܾ�
	private String engWord; // �������� ã�� ���� �ܾ�
	
	public DicApp() {
		sc = new Scanner(System.in);
	}
	
	public void run() {
		System.out.println("�ѿ� �ܾ� �˻� ���α׷��Դϴ�.");
		
		while(true) {
			System.out.print("�ѱ� �ܾ�? ");
			korWord = sc.nextLine();
			
			if (korWord.equals("�׸�")) break; // "�׸�" �Է��ϸ� ���α׷� ����
			
			engWord = Dictionary.kor2Eng(korWord);
			// ���� �ܾ ã�� ���� ���
			if (engWord == null) {
				System.out.println(korWord + "��(��) ���� ������ �����ϴ�.");
				continue;
			}
			System.out.println(korWord + "��(��) " + engWord); // ���� �ܾ ã���� ���
		}
		System.out.println("�����մϴ�...");
	}

	public static void main(String[] args) {
		DicApp dictionary = new DicApp();
		dictionary.run();
		
	}

}

