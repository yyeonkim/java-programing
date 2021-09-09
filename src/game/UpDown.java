package game;

import java.util.*;

public class UpDown {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		// ����ڰ� ���ϴ� ��ŭ ������ ��� �����Ѵ�.
		while (true) {
			int low = 0;
			int high = 99;
			int i = 1; // �õ� Ƚ��
			int card = r.nextInt(100); // ī�忡 ���� �� (����)
			
			System.out.println("���� �����߽��ϴ�. ���� ������.");
			
			// ������ ���� ������ ��� �����Ѵ�.
			while (true) {
				int answer; // ����ڰ� ����� ��
				
				System.out.printf("%d-%d\n", low, high);
				System.out.printf("%d >> ", i);
				
				// ����ڰ� ���ڸ� �Է��ϸ� ���� ó��
				try { 
					answer = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("������ �Է��ϼ���.");
					sc.nextLine(); // ���� ������
					continue;
				}	
				
				if (card == answer) {  // �����̸�
					break;
				} else if (card > answer) {  // ���亸�� ���ڰ� ������
					System.out.println("�� ����");
					i++; // �õ� Ƚ�� ����s
					low = answer;
					continue;
				} else {  // ���亸�� ���ڰ� ũ��
					System.out.println("�� ����");
					i++;  // �õ� Ƚ�� ����
					high = answer;
					continue;
				}
			}
			
			System.out.printf("%d�� ���� �� ������ϴ�. �ٽ��Ͻðڽ��ϱ�?(y/n) ", i);
			char c = sc.next().charAt(0);
			
			if (c == 'n') break;
			else if (c == 'y');
			else {  // n, y �ܿ� �ٸ� �� �Է� �� �׳� �����Ѵ�.
				System.out.println("�߸��� �����Դϴ�.");
				break;
			}
		}
		
		System.out.println("������ �����մϴ�.");
		sc.close();
	}

}
