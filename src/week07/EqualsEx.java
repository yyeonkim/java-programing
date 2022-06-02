package week07;

public class EqualsEx {

	public static void main(String[] args) {
//		Point a = new Point(2, 3);
//		Point b = new Point(2, 3);
//		Point c = new Point(3, 4);
//		
//		if (a == b) System.out.println("a == b");
//		
//		if (a.equals(b)) System.out.println("a is equal to b");
//		
//		if (a.equals(c)) System.out.println("a is equal to c");
		
		Rect a = new Rect(2, 3);
		Rect b = new Rect(3, 2);
		Rect c = new Rect(3, 4);
		
		if (a.equals(b))
			System.out.println("a is equal to b");
		if (a.equals(c))
			System.out.println("a is equal to c");
		if (b.equals(c))
			System.out.println("b is equal to c");
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}	

}
