package game;

import java.util.Scanner;

public class GameRSPMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���������� �����Դϴ�. ����, ����, �� �߿��� �Է��ϼ���.");
		System.out.print("��ȭ >> "); 
		String ewha = sc.next();  // ��ȭ ���ڿ� �Է¹ޱ�
		System.out.print("�İ� >> ");
		String computer = sc.next();  // �İ� ���ڿ� �Է¹ޱ�
		
		String result = "";
		
		// ���� ���� ���� �� ��
		if (ewha.equals(computer)) 
			result = "�����ϴ�.";
		
		// ��ȭ�� ������ ��
		if (ewha.equals("����")) {
			if (computer.equals("��"))
				result = "��ȭ�� �̰���ϴ�.";
			else if (computer.equals("����")) 
				result = "�İ��� �̰���ϴ�.";
		}
		// ��ȭ�� ������ ��
		if (ewha.equals("����")) {
			if (computer.equals("����"))
				result = "��ȭ�� �̰���ϴ�.";
			else if (computer.equals("��")) 
				result = "�İ��� �̰���ϴ�.";	
		}
		// ��ȭ�� ���� ��
		if (ewha.equals("��")) {
			if (computer.equals("����"))
				result = "��ȭ�� �̰���ϴ�.";
			else if (computer.equals("����")) 
				result = "�İ��� �̰���ϴ�.";
		}
		
		System.out.println(result);
		sc.close();
	}

}
