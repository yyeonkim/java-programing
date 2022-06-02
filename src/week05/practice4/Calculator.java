package week05.practice4;

import java.util.*;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ������ �����ڸ� �Է��Ͻÿ� >> ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		char operator = sc.next().charAt(0);
		sc.nextLine();
		
		Calc exp;
		
		switch(operator) {
			case '+': exp = new Add(); break;
			case '-': exp = new Sub(); break;
			case '*': exp = new Mul(); break;
			case '/': exp = new Div(); break;
			default:
				System.out.println("�߸��� �������Դϴ�.");
				sc.close();
				return;
		}
		
		exp.setValue(a, b);
		if (exp instanceof Div && b == 0)
			System.out.println("0���� ���� �� �����ϴ�.");
		else
			System.out.println(exp.calculate());
		
		sc.close();

	}

}
