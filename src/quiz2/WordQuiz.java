package quiz2;

import java.util.*;

public class WordQuiz {
	
	private String name; // 퀴즈 프로그램 이름
	private Vector<Word> v;
	private Scanner sc = new Scanner(System.in);
	
	public WordQuiz(String name) {
		this.name = name;
		
		v = new Vector<Word>();
		
		v.add(new Word("love", "사랑"));
		v.add(new Word("animal", "동물"));
		v.add(new Word("emotion", "감정"));
		v.add(new Word("human", "인간"));
		v.add(new Word("stock", "주식"));
		v.add(new Word("trade", "거래"));
		v.add(new Word("society", "사회"));
		v.add(new Word("baby", "아기"));
		v.add(new Word("honey", "애인"));
		v.add(new Word("dall", "인형"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("picture", "사진"));
		v.add(new Word("painting", "그림"));
		v.add(new Word("fault", "오류"));
		v.add(new Word("example", "보기"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("statue", "조각상"));
	}
	
	// 테스트 보기 만들기
	private int makeExample(int ex[], int answerIndex) {
		int n[] = {-1, -1, -1, -1}; // -1로 초기화
		int index;
		
		for (int i = 0; i < n.length; i++) {
			do {
				index = (int) (Math.random() * v.size()); // 랜덤 index
			} while (index == answerIndex || exists(n, index)); // 정답이거나 이미 있으면 다시
			n[i] = index; // n에 인덱스 추가
		} // end for
		
		for (int i = 0; i < n.length; i++) {
			ex[i] = n[i]; // ex로 index 옮기기
		}
		return (int) (Math.random() * n.length); // 문제에서 답으로 할 번호 return
	}
	
	private boolean exists(int n[], int index) {
		for (int i = 0; i < n.length; i++) {
			if (n[i] == index) return true;
		}
		return false;
	}
	
	private void wordQuiz() {
		System.out.println("\n현재 " + v.size() + "개의 단어가 들어 있습니다. -1을 입력하면 테스트를 종료합니다.");
		
		while (true) {
			// 정답 설정
			int answerIndex = (int) (Math.random() * v.size());
			String eng = v.get(answerIndex).getEnglish();
			
			// 4개의 보기를 만들 벡터의 index 배열
			int example[] = new int [4];
			
			int answerLoc = makeExample(example, answerIndex); // 보기의 정답
			example[answerLoc] = answerIndex; // v의 정답 index 저장
			
			// 문제를 출력합니다.
			System.out.println("\n" + eng + "?");
			for (int i = 0; i < example.length; i++)
				System.out.print("(" + (i + 1) + ")" + v.get(example[i]).getKorean() + " ");
			
			System.out.print(":> "); // 프롬프트
			try {
				int in = sc.nextInt();
				if (in == -1) break;
				
				// 사용자가 1~4 사이의 정답 입력
				in--;
				if (in == answerLoc)
					System.out.println("Excellent !!");
				else
					System.out.println("No !!");
			} catch(InputMismatchException e) {
				sc.next();
				System.out.println("정수를 입력하세요 !!");
			}			
		}
	}
	
	private void insertWords() {
		System.out.println("\n영어 단어에 그만을 입력하면 종료합니다.");
		
		while (true) {
			System.out.print("영어 한글 입력 >> ");
			String eng = sc.next();
			if (eng.equals("그만")) break;
			String kor = sc.next();
			sc.nextLine();
			v.add(new Word(eng, kor));			
		}
	}
	
	private void deleteWords() {
		System.out.println("번호에 -1을 입력하면 종료합니다.");
		while (true) {
			System.out.print("번호 >> ");
			int index = 0;
			try {
				index = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("정수를 입력하세요.");
				sc.nextLine();
				continue;
			}
			sc.nextLine();
			if (index == -1) break;
			if (index >= v.size()) {
				System.out.println("해당하는 단어가 없습니다.");
				continue;
			} 
			Word deletedWord =  v.get(index);
			System.out.println(deletedWord.getEnglish() + "를 삭제했습니다.");
			v.remove(index);
		}
		
	}
	
	private void run() {
		System.out.println("**** 영어 단어 테스트 프로그램 \"" + name + "\" 입니다. ****");
		
		while (true) {
			System.out.print("\n단어 테스트: 1, 단어 삽입: 2, 단어 삭제: 3, 종료: 4 >> ");
			int user;
			try {
				user = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("1~4 중 하나를 입력하세요.");
				sc.nextLine();
				continue;
			}
			sc.nextLine();
			
			switch(user) {
				case 1: wordQuiz(); break;
				case 2: insertWords(); break;
				case 3: deleteWords(); break;
				case 4: System.out.println("\"" + name + "\"를 종료합니다."); System.exit(0);;
				default: 
					System.out.println("1~4 중 하나를 입력하세요."); continue;
			}
		}
	}

	public static void main(String[] args) {
		WordQuiz quiz = new WordQuiz("명품영어");
		quiz.run();
	}

}
