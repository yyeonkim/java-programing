package week04;

import java.util.*;

public class Bear extends GameObject {
	private Scanner sc;
	
	public Bear(int x, int y, int distance) {
		super(x, y, distance);
		sc = new Scanner(System.in);
		System.out.println("Bear ������");
	}

	@Override
	protected void move() {
		while(true) {
			System.out.print("����(a), �Ʒ�(s), ��(w), ������(d) >> ");
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
					System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
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
