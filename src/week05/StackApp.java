package week05;

import java.util.*;

public class StackApp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int capacity; // �� ���� ���� ���� ũ��
		
		while (true) {
			try {
				System.out.print("�� ���� ���� ������ ũ�� �Է� >> ");
				capacity = sc.nextInt();
				
			} catch (InputMismatchException e) {
				System.out.println("������ �Է��ϼ���.");
				sc.nextLine();
				continue;
			}
			sc.nextLine();
			break;
		}
		
		StringStack ss = new StringStack(capacity);
		
		while (true) {
			System.out.print("���ڿ� �Է� >> ");
			String str = sc.nextLine();
			
			if (str.equals("�׸�")) break;
			
			boolean res = ss.push(str);
			
			if (!res) {
				System.out.println("������ �� ���� Ǫ�� �Ұ�!");
			}
		}
		
		System.out.print("���ÿ� ����� ��� ���ڿ� ��: ");
		int length = ss.length();
		for (int i = 0; i < length; i++) {
			System.out.print(ss.pop() + " ");
		}
		System.out.println();
		
		sc.close();
	}

}
