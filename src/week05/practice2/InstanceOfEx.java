package week05.practice2;

// 이 위에 바로 class를 생성한다면 bin 폴더에 각 class 파일이 모두 생성된다. (binary file, byte code)

public class InstanceOfEx {
	static void print(Person p) {
		if (p instanceof Person)
			System.out.print("Person ");
		if (p instanceof Student)
			System.out.print("Student ");
		if (p instanceof Researcher)
			System.out.print("Researcher ");
		if (p instanceof Professor)
			System.out.print("Professor ");
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.print("new Student() -->\t"); print(new Student("사람"));
		System.out.print("new Researcher() -->\t"); print(new Researcher("사람"));
		System.out.print("new Professor() -->\t"); print(new Professor("사람"));
	}

}
