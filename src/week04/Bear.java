package week04;

import java.util.*;

public class Bear extends GameObject {
	private Scanner sc;
	
	public Bear(int x, int y, int distance) {
		super(x, y, distance);
		sc = new Scanner(System.in);
		System.out.println("Bear 생성자");
	}

	@Override
	protected void move() {
		while(true) {
			System.out.print("왼쪽(a), 아래(s), 위(w), 오른쪽(d) >> ");
			char moveKey = sc.next().charAt(0);
			System.out.println(moveKey);
			sc.nextLine();
			
			switch(moveKey) {
				case 'a':
					x -= distance;
					if (x < 0) x = 0;
					break;
				case 's':
					y += distance;
					if (y > Game.MAX_Y) y = Game.MAX_Y - 1;
					break;
				case 'w':
					y -= distance;
					if (y < 0) y = 0;
					break;
				case 'd':
					x += distance;
					if (x > Game.MAX_Y -1) x = Game.MAX_Y - 1;
					break;
				default:
					System.out.println("잘못 입력했습니다. 다시 입력하세요.");
					continue;
			}
			break;
		}
	}

	@Override
	protected char getShape() {
		return 'B';
	}
	
}
