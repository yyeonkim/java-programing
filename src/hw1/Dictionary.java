package hw1;

public class Dictionary {
	private static String[] kor = {"���", "�Ʊ�", "��", "�̷�", "���"};
	private static String[] eng = {"love", "baby", "money", "future", "hope"};
	
	public static String kor2Eng(String korWord) {
		for (int i = 0; i < kor.length; i++) {
			if(korWord.equals(kor[i])) return eng[i]; // ã���� ���� �ܾ� ��ȯ
		}
		return null; // ã�� ���ϸ� null ��ȯ
	}
}

