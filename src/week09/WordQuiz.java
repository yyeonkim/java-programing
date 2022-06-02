package week09;
import java.util.*;

public class WordQuiz {
	
	private String name; // 퀴즈 프로그램 이름
	private Vector<Word> v;
	
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
		v.add(new Word("honey", "꿀"));
		v.add(new Word("book", "책"));
		v.add(new Word("teacher", "선생님"));
		v.add(new Word("cook", "요리"));
		v.add(new Word("desk", "책상"));
		v.add(new Word("pencil", "연필"));
		v.add(new Word("cup", "컵"));
	}
	
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
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\"" + name + "\"" + "의 단어 테스트를 시작합니다.");
		System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");;
		
		while (true) {
			// 정답 설정
			int answerIndex = (int) (Math.random() * v.size());
			String eng = v.get(answerIndex).getEnglish();
			
			// 4개의 보기를 만들 벡터의 index 배열
			int example[] = new int [4];
			
			int answerLoc = makeExample(example, answerIndex); // 보기의 정답
			example[answerLoc] = answerIndex; // v의 정답 index 저장
			// System.out.println("example[" + answerLoc + "] = " + answerIndex);
			
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
		System.out.print("\"" + name + "\"를 종료합니다...");
		sc.close();
		
	}

	public static void main(String[] args) {
		WordQuiz quiz = new WordQuiz("명품영어");
		quiz.run();

	}

}
