package week10;

import java.util.*;
import java.io.*;

public class FileWriterEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FileWriter fout = null;
		System.out.println("�Ʒ� ������ �Է��ϼ���:");
		
		try {
			fout = new FileWriter("C:\\Users\\82103\\Downloads\\test.txt");
			while (true) {
				String line = sc.nextLine();
				if (line.length() == 0) break;
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();
		} catch (IOException e) {
			System.out.println("����� ����");
		}
		sc.close();
	}

}
