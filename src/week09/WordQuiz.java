package week09;
import java.util.*;

public class WordQuiz {
	
	private String name; // ���� ���α׷� �̸�
	private Vector<Word> v;
	
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
		v.add(new Word("honey", "��"));
		v.add(new Word("book", "å"));
		v.add(new Word("teacher", "������"));
		v.add(new Word("cook", "�丮"));
		v.add(new Word("desk", "å��"));
		v.add(new Word("pencil", "����"));
		v.add(new Word("cup", "��"));
	}
	
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
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\"" + name + "\"" + "�� �ܾ� �׽�Ʈ�� �����մϴ�.");
		System.out.println("���� " + v.size() + "���� �ܾ ��� �ֽ��ϴ�.");;
		
		while (true) {
			// ���� ����
			int answerIndex = (int) (Math.random() * v.size());
			String eng = v.get(answerIndex).getEnglish();
			
			// 4���� ���⸦ ���� ������ index �迭
			int example[] = new int [4];
			
			int answerLoc = makeExample(example, answerIndex); // ������ ����
			example[answerLoc] = answerIndex; // v�� ���� index ����
			// System.out.println("example[" + answerLoc + "] = " + answerIndex);
			
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
		System.out.print("\"" + name + "\"�� �����մϴ�...");
		sc.close();
		
	}

	public static void main(String[] args) {
		WordQuiz quiz = new WordQuiz("��ǰ����");
		quiz.run();

	}

}
