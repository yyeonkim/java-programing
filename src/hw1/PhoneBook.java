package hw1;

import java.util.*;

public class PhoneBook {
	private int nPeople; // 인원 수
	private Scanner sc;
	private Phone[] phones; // 사람의 정보를 저장할 Phone 배열
	
	public PhoneBook() {
		sc = new Scanner(System.in);
	}
	
	// 인원 수 물어보기
	public void getNumberOfPeople() {
		// 문자 입력 시 예외처리
		while (true) {
			System.out.print("인원 수 >> ");
			try {
				nPeople = sc.nextInt();
			} catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수를 입력하세요.");
				continue;
			}
			break;
		}
		sc.nextLine();
		phones = new Phone[nPeople];
	}
	
	// 인원 수 만큼 Phone에 사람 정보 저장하기
	public void storeData() {
		for (int i = 0; i < nPeople; i++) {
			String name;
			String tel;
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력) >> ");
			name = sc.next();
			tel = sc.next();
			sc.nextLine();
			phones[i] = new Phone(name, tel);
		}
		System.out.println("저장되었습니다...");
	}
	
	// 정보 찾기
	public void search() {
		while(true) {
			System.out.print("검색할 이름 >> ");
			String searchName = sc.nextLine();
			// "그만" 입력하면 프로그램 종료하기
			if (searchName.equals("그만")) {
				System.out.println("종료합니다...");
				break;
			}
			// 이름으로 검색하기
			for (Phone phone: phones) {
				String name = phone.getName();
				// 검색한 이름이 있으면 번호 출력, 없으면 없다고 출력
				if(name.equals(searchName)) {
					System.out.println(name + "의 번호는 " + phone.getTel() + " 입니다.");
					break;
				}
			}
			System.out.println(searchName + "이(가) 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		PhoneBook phone = new PhoneBook();
		phone.getNumberOfPeople();
		phone.storeData();
		phone.search();
	}

}
