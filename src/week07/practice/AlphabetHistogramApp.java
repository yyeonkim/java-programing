package week07.practice;

import java.util.*;

public class AlphabetHistogramApp {
//	private int histoData[] = new int[26];
	private int histoData[] = new int[52]; // 대문자 + 소문자
	
	public AlphabetHistogramApp() {
		for (int i = 0; i < histoData.length; i++)
			histoData[i] = 0;
	}
	
	String readString() {
		System.out.println("영문 텍스트를 입력하고 세미톨론을 입력하세요.");

		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String line = sc.nextLine(); // 한 줄
			if (line.equals(";")) break;
			sb.append(line); // 한 줄 추가
		}
		sc.close();
		
		return sb.toString(); // 스트링 버퍼의 문자 리턴
	}
	
	public void makeHistogram(String text) {
		String s = text.toString(); // 스트링 버퍼의 문자열을 스트링으로 리턴
//		s = s.toUpperCase(); // 대문자로 변경
		
		System.out.println(s);
		
		// 입력된 문자를 히스토 데이터로 만든다.
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i); // 한 문자
			if (c >= 'A' && c <= 'Z') { // 알파벳일 경우
				int index = c - 'A'; // A 아스키코드 65
				histoData[index]++;
			}
			if (c >= 'a' && c <= 'z') {
				int index = (char) c - 71; // a 아스키코드 97 --> index 26에서 시작
				histoData[index]++;
			}
		}
	}
	
	public void drawHistogram() {
		System.out.println("히스토그램을 그립니다.");
		// 대문자 출력
		for (int i = 0; i < histoData.length / 2; i++) { // 배열의 반까지
			System.out.print((char)('A' + i)); // 문자 출력 A ~ Z
			
			for (int j = 0; j < histoData[i]; j++) {
				System.out.print("-"); // 히스토 개수만큼 출력
			}
			System.out.println();
		}
		// 소문자 출력
		for (int i = 0; i < histoData.length / 2; i++) {
			System.out.print((char)('a' + i)); // 문자 출력 a ~ z
			
			for (int j = 0; j < histoData[i + 26]; j++) { // 배열 26 자리 부터 끝까지
				System.out.print("-"); // 히스토 개수만큼 출력
			}
			System.out.println();
		}
	}
	
	public void run() {
		String s = readString();
		makeHistogram(s);
		drawHistogram();
	}
	
	
	public static void main(String[] args) {
		AlphabetHistogramApp app = new AlphabetHistogramApp();
		app.run();
		System.out.println("종료합니다...");
	}
	
}
