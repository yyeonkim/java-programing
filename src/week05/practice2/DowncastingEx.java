package week05.practice2;

public class DowncastingEx {

	public static void main(String[] args) {
		Person p = new Student("���繮");
		Student s;
		
		s = (Student) p;
		
		System.out.println(s.name);
		s.grade = "A";
		System.out.println(s.grade);
		// p.grade = "B";
	}

}
