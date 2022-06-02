package week07.practice;

import java.util.*;

public class AlphabetHistogramApp {
//	private int histoData[] = new int[26];
	private int histoData[] = new int[52]; // �빮�� + �ҹ���
	
	public AlphabetHistogramApp() {
		for (int i = 0; i < histoData.length; i++)
			histoData[i] = 0;
	}
	
	String readString() {
		System.out.println("���� �ؽ�Ʈ�� �Է��ϰ� ��������� �Է��ϼ���.");

		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String line = sc.nextLine(); // �� ��
			if (line.equals(";")) break;
			sb.append(line); // �� �� �߰�
		}
		sc.close();
		
		return sb.toString(); // ��Ʈ�� ������ ���� ����
	}
	
	public void makeHistogram(String text) {
		String s = text.toString(); // ��Ʈ�� ������ ���ڿ��� ��Ʈ������ ����
//		s = s.toUpperCase(); // �빮�ڷ� ����
		
		System.out.println(s);
		
		// �Էµ� ���ڸ� ������ �����ͷ� �����.
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i); // �� ����
			if (c >= 'A' && c <= 'Z') { // ���ĺ��� ���
				int index = c - 'A'; // A �ƽ�Ű�ڵ� 65
				histoData[index]++;
			}
			if (c >= 'a' && c <= 'z') {
				int index = (char) c - 71; // a �ƽ�Ű�ڵ� 97 --> index 26���� ����
				histoData[index]++;
			}
		}
	}
	
	public void drawHistogram() {
		System.out.println("������׷��� �׸��ϴ�.");
		// �빮�� ���
		for (int i = 0; i < histoData.length / 2; i++) { // �迭�� �ݱ���
			System.out.print((char)('A' + i)); // ���� ��� A ~ Z
			
			for (int j = 0; j < histoData[i]; j++) {
				System.out.print("-"); // ������ ������ŭ ���
			}
			System.out.println();
		}
		// �ҹ��� ���
		for (int i = 0; i < histoData.length / 2; i++) {
			System.out.print((char)('a' + i)); // ���� ��� a ~ z
			
			for (int j = 0; j < histoData[i + 26]; j++) { // �迭 26 �ڸ� ���� ������
				System.out.print("-"); // ������ ������ŭ ���
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
		System.out.println("�����մϴ�...");
	}
	
}
