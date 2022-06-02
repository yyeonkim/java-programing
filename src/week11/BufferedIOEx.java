package week11;

import java.io.*;
import java.util.*;

public class BufferedIOEx {

	public static void main(String[] args) {
		FileReader fin = null;
		Scanner sc = new Scanner(System.in);
		int c;
		
		try {
			fin = new FileReader("C:\\Users\\82103\\Downloads\\test2.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
			while ((c = fin.read()) != -1)
				out.write(c);
			
			sc.nextLine();
			out.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
