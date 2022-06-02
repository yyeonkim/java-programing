package quiz2;

import java.util.*;

public class WordQuiz {
	
	private String name; // ���� ���α׷� �̸�
	private Vector<Word> v;
	private Scanner sc = new Scanner(System.in);
	
	public WordQuiz(String name) {
		this.name = name;
		
		v = new Vector<Word>();
		
		v.add(new Word("love", "���"));
		v.add(new Word("animal", "����"));
		v.add(new Word("emotion", "����"));
		v.add(new Word("human", "�ΰ�"));
		v.add(new Word("stock", "�ֽ�"));
		v.add(new Word("trade", "�ŷ�"));
		v.add(new Word("society", "��ȸ"));
		v.add(new Word("baby", "�Ʊ�"));
		v.add(new Word("honey", "����"));
		v.add(new Word("dall", "����"));
		v.add(new Word("bear", "��"));
		v.add(new Word("picture", "����"));
		v.add(new Word("painting", "�׸�"));
		v.add(new Word("fault", "����"));
		v.add(new Word("example", "����"));
		v.add(new Word("eye", "��"));
		v.add(new Word("statue", "������"));
	}
	
	// �׽�Ʈ ���� �����
	private int makeExample(int ex[], int answerIndex) {
		int n[] = {-1, -1, -1, -1}; // -1�� �ʱ�ȭ
		int index;
		
		for (int i = 0; i < n.length; i++) {
			do {
				index = (int) (Math.random() * v.size()); // ���� index
			} while (index == answerIndex || exists(n, index)); // �����̰ų� �̹� ������ �ٽ�
			n[i] = index; // n�� �ε��� �߰�
		} // end for
		
		for (int i = 0; i < n.length; i++) {
			ex[i] = n[i]; // ex�� index �ű��
		}
		return (int) (Math.random() * n.length); // �������� ������ �� ��ȣ return
	}
	
	private boolean exists(int n[], int index) {
		for (int i = 0; i < n.length; i++) {
			if (n[i] == index) return true;
		}
		return false;
	}
	
	private void wordQuiz() {
		System.out.println("\n���� " + v.size() + "���� �ܾ ��� �ֽ��ϴ�. -1�� �Է��ϸ� �׽�Ʈ�� �����մϴ�.");
		
		while (true) {
			// ���� ����
			int answerIndex = (int) (Math.random() * v.size());
			String eng = v.get(answerIndex).getEnglish();
			
			// 4���� ���⸦ ���� ������ index �迭
			int example[] = new int [4];
			
			int answerLoc = makeExample(example, answerIndex); // ������ ����
			example[answerLoc] = answerIndex; // v�� ���� index ����
			
			// ������ ����մϴ�.
			System.out.println("\n" + eng + "?");
			for (int i = 0; i < example.length; i++)
				System.out.print("(" + (i + 1) + ")" + v.get(example[i]).getKorean() + " ");
			
			System.out.print(":> "); // ������Ʈ
			try {
				int in = sc.nextInt();
				if (in == -1) break;
				
				// ����ڰ� 1~4 ������ ���� �Է�
				in--;
				if (in == answerLoc)
					System.out.println("Excellent !!");
				else
					System.out.println("No !!");
			} catch(InputMismatchException e) {
				sc.next();
				System.out.println("������ �Է��ϼ��� !!");
			}			
		}
	}
	
	private void insertWords() {
		System.out.println("\n���� �ܾ �׸��� �Է��ϸ� �����մϴ�.");
		
		while (true) {
			System.out.print("���� �ѱ� �Է� >> ");
			String eng = sc.next();
			if (eng.equals("�׸�")) break;
			String kor = sc.next();
			sc.nextLine();
			v.add(new Word(eng, kor));			
		}
	}
	
	private void deleteWords() {
		System.out.println("��ȣ�� -1�� �Է��ϸ� �����մϴ�.");
		while (true) {
			System.out.print("��ȣ >> ");
			int index = 0;
			try {
				index = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("������ �Է��ϼ���.");
				sc.nextLine();
				continue;
			}
			sc.nextLine();
			if (index == -1) break;
			if (index >= v.size()) {
				System.out.println("�ش��ϴ� �ܾ �����ϴ�.");
				continue;
			} 
			Word deletedWord =  v.get(index);
			System.out.println(deletedWord.getEnglish() + "�� �����߽��ϴ�.");
			v.remove(index);
		}
		
	}
	
	private void run() {
		System.out.println("**** ���� �ܾ� �׽�Ʈ ���α׷� \"" + name + "\" �Դϴ�. ****");
		
		while (true) {
			System.out.print("\n�ܾ� �׽�Ʈ: 1, �ܾ� ����: 2, �ܾ� ����: 3, ����: 4 >> ");
			int user;
			try {
				user = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("1~4 �� �ϳ��� �Է��ϼ���.");
				sc.nextLine();
				continue;
			}
			sc.nextLine();
			
			switch(user) {
				case 1: wordQuiz(); break;
				case 2: insertWords(); break;
				case 3: deleteWords(); break;
				case 4: System.out.println("\"" + name + "\"�� �����մϴ�."); System.exit(0);;
				default: 
					System.out.println("1~4 �� �ϳ��� �Է��ϼ���."); continue;
			}
		}
	}

	public static void main(String[] args) {
		WordQuiz quiz = new WordQuiz("��ǰ����");
		quiz.run();
	}

}
