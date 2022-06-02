package week11;

import java.io.*;

public class BinaryCopyEx {

	public static void main(String[] args) {
		File src = new File("C:\\Users\\82103\\Downloads\\preview.jpg");
		File dest1 = new File("C:\\Users\\82103\\Pictures\\copyimg.jpg");
		File dest2 = new File("C:\\Users\\82103\\Pictures\\wallpaper\\copyimg.jpg");
		File dest3 = new File("C:\\Users\\82103\\Pictures\\Saved Pictures\\copyimg.jpg");
		File dest4 = new File("C:\\Users\\82103\\Pictures\\Screenshots\\copyimg.jpg");
		int c;
		
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo1 = new FileOutputStream(dest1);
			FileOutputStream fo2 = new FileOutputStream(dest2);
			FileOutputStream fo3 = new FileOutputStream(dest3);
			FileOutputStream fo4 = new FileOutputStream(dest4);
			
			while ((c = fi.read()) != -1) {
				fo1.write((byte) c);
				fo2.write((byte) c);
				fo3.write((byte) c);
				fo4.write((byte) c);
			} 	

			fi.close();
			fo1.close();
			fo2.close();
			fo3.close();
			fo4.close();
			
			System.out.println("복사하였습니다.");
		} catch(IOException e) {
			System.out.println("파일 복사 오류");
		}

	}
	
}