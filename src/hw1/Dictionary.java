package hw1;

public class Dictionary {
	private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
	private static String[] eng = {"love", "baby", "money", "future", "hope"};
	
	public static String kor2Eng(String korWord) {
		for (int i = 0; i < kor.length; i++) {
			if(korWord.equals(kor[i])) return eng[i]; // 찾으면 영어 단어 반환
		}
		return null; // 찾지 못하면 null 반환
	}
}

