package week05.practice4;

import java.util.*;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오 >> ");
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
				System.out.println("잘못된 연산자입니다.");
				sc.close();
				return;
		}
		
		exp.setValue(a, b);
		if (exp instanceof Div && b == 0)
			System.out.println("0으로 나눌 수 없습니다.");
		else
			System.out.println(exp.calculate());
		
		sc.close();

	}

}
