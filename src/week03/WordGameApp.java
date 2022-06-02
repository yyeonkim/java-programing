package week03;

import java.util.*;

public class WordGameApp {
	// �ʵ�(����) ����
	private Scanner sc; // Ű���� �Է�
	private String startWord = "�ƹ���"; // ���� �ܾ�
	private Player[] players; // ���� ������
	
	// ������ �޼ҵ�
	public WordGameApp() {
		sc = new Scanner(System.in);
	}
	
	// ������ �� �Է¹ް� Player[] �迭�� �����ϴ� �޼ҵ�
	private void createPlayers() {
		int nPlayers = 0; // Player ��
		while(true) {
			System.out.print("���ӿ� �����ϴ� �ο��� �� ���Դϱ�? >> ");
			// ���� �Է� �� ���� ó��
			try {
				nPlayers = sc.nextInt();
			} catch (InputMismatchException e) { // ������ �ƴ� ���ڸ� �Է����� ���
				sc.nextLine();
				System.out.println("������ �Է��ϼ���.");
				continue;
			}
			break;
		}
		sc.nextLine();
		players = new Player[nPlayers]; // ��� ��ŭ Player �迭 �Ҵ�
		// �� ������ �̸��� �Է¹޾� Player ��ü ����
		for (int i = 0; i < nPlayers; i++) {
			System.out.print("�������� �̸��� �Է��ϼ��� >> ");
			String name = sc.nextLine();
			players[i] = new Player(name); // ��ü ����
		}
	}
	
	// ������ �����ϴ� �޼ҵ�
	public void run() {
		System.out.println("�����ձ� ������ �����մϴ�...");
		createPlayers(); // �����ڸ� ���� Player[]�� �����Ѵ�.
		String lastWord = startWord; // startWord���� ���� �����Ѵ�.
		System.out.println("�����ϴ� �ܾ�� " + lastWord + "�Դϴ�.");
		int next = 0; // ���� player index
		// ������ ���� ������ ����
		while (true) {
			// next �����ڰ� �ܾ ���ϵ��� �Ѵ�. ���� �ܾ newWord�� ����.
			String newWord = players[next].getWordFromUser(); 
			// next �����ڰ� �����Ͽ����� �˻�
			if (!players[next].checkSuccess(lastWord)) { 
				System.out.print(players[next].getName() + "��(��) �����ϴ�.");
				break; // ���� ����
			}
			next++; // ���� ������
			next %= players.length; // next�� �������� �������� ���� �����ϴ� ���� ���´�. ������ ������ �ݺ��ȴ�.
			lastWord = newWord; // �����ڰ� ���� �ܾ lastWord�� ����
		}
		
	}
	
	// main�� Ŭ������ �и��ϱ�
	public static void main(String[] args) { 
		WordGameApp game = new WordGameApp(); // ������ ��ü (�ڵ� ���� ȿ��)
		game.run();

	}

}
