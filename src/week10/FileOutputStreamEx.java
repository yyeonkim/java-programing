package week10;

import java.io.*;

public class FileOutputStreamEx {

	public static void main(String[] args) {
		byte[] b = {7, 51, 3, 4, -1, 24};
		
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Users\\82103\\Downloads\\test.txt");
			for (int i = 0; i < b.length; i++) fout.write(b[i]);
			fout.close();
		} catch (IOException e) {
			System.out.println("C:\\Users\\82103\\Downloads\\test.txt에 저장할 수 없습니다. 경로명을 확인해 주세요");
			return;
		}
		System.out.println("C:\\Users\\82103\\Downloads\\test.txt에 저장했습니다.");

	}

}
