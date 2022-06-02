package week10;

import java.io.*;

public class FileInputStreamEx {

	public static void main(String[] args) {
		byte[] b = new byte[6];
		
		try {
			FileInputStream fin = new FileInputStream("C:\\Users\\82103\\Downloads\\test.txt");
			int n = 0, c;
			while ((c = fin.read()) != -1) {
				b[n] = (byte) c; // 2진수 --> 10진수
				n++;
			}
			System.out.println("읽은 배열을 출력합니다.");
			for(int i = 0; i < b.length; i++) System.out.print(b[i] + " ");
			fin.close();
		} catch (IOException e) {
			System.out.println("읽지 못했습니다. 경로명을 확인해보세요.");
		}

	}

}
