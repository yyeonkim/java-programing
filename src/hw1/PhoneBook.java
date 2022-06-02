package hw1;

import java.util.*;

public class PhoneBook {
	private int nPeople; // �ο� ��
	private Scanner sc;
	private Phone[] phones; // ����� ������ ������ Phone �迭
	
	public PhoneBook() {
		sc = new Scanner(System.in);
	}
	
	// �ο� �� �����
	public void getNumberOfPeople() {
		// ���� �Է� �� ����ó��
		while (true) {
			System.out.print("�ο� �� >> ");
			try {
				nPeople = sc.nextInt();
			} catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("������ �Է��ϼ���.");
				continue;
			}
			break;
		}
		sc.nextLine();
		phones = new Phone[nPeople];
	}
	
	// �ο� �� ��ŭ Phone�� ��� ���� �����ϱ�
	public void storeData() {
		for (int i = 0; i < nPeople; i++) {
			String name;
			String tel;
			System.out.print("�̸��� ��ȭ��ȣ(�̸��� ��ȣ�� �� ĭ ���� �Է�) >> ");
			name = sc.next();
			tel = sc.next();
			sc.nextLine();
			phones[i] = new Phone(name, tel);
		}
		System.out.println("����Ǿ����ϴ�...");
	}
	
	// ���� ã��
	public void search() {
		while(true) {
			System.out.print("�˻��� �̸� >> ");
			String searchName = sc.nextLine();
			// "�׸�" �Է��ϸ� ���α׷� �����ϱ�
			if (searchName.equals("�׸�")) {
				System.out.println("�����մϴ�...");
				break;
			}
			// �̸����� �˻��ϱ�
			for (Phone phone: phones) {
				String name = phone.getName();
				// �˻��� �̸��� ������ ��ȣ ���, ������ ���ٰ� ���
				if(name.equals(searchName)) {
					System.out.println(name + "�� ��ȣ�� " + phone.getTel() + " �Դϴ�.");
					break;
				}
			}
			System.out.println(searchName + "��(��) �����ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		PhoneBook phone = new PhoneBook();
		phone.getNumberOfPeople();
		phone.storeData();
		phone.search();
	}

}
