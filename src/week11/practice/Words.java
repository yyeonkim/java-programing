package week11.practice;

import java.util.*;
import java.io.*;

public class Words {
	Vector<String> wordVector = new Vector<String>();
	
	public Words(String fileName) {
		try {
			Scanner sc = new Scanner(new FileReader(fileName));
			while (sc.hasNext()) {
				String word = sc.nextLine();
				wordVector.add(word);
			}
			sc.close();
		} catch(FileNotFoundException e) {
			System.out.println("File not found error");
			System.exit(0);
		}
	}
	
	public String getRandomWord() {
		final int WORDMAX = wordVector.size(); // 총 단어의 개수
		int index = (int) (Math.random() * WORDMAX);
		return wordVector.get(index);				
	}
	
}
