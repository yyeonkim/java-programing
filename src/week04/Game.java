package week04;

public class Game {
	public static final int MAX_X = 20;
	public static final int MAX_Y = 10;
	private char[][] map = new char [MAX_Y][MAX_X];
	private GameObject[] member = new GameObject[2];
	// private int state; // 0: ���� ��, 1: Bear�� win, 2: Fish�� win
	
	public Game() {
		for (int i = 0; i < MAX_Y; i++)
			for (int j = 0; j < MAX_X; j++)
				map[i][j] = '-';
		
		member[0] = new Bear(0, 0, 1);
		member[1] = new Fish(5, 5, 1);
		// state = 0; // ���� ��
	}
	
	public void run() {
		System.out.println("** Bear�� Fish �Ա� ������ �����մϴ�. **");
		
		update(); // �ʱ� ��ǥ�� ���� �� ����
		draw(); // �ʱ� ���� �� �����ֱ�
		
		while (!doesEnd()) {
			clear(); // ���� �� ����
			for (int i = 0; i < member.length; i++)
				member[i].move();
			update();
			draw();
		}
		System.out.println("Bear ��!");
	}
	
	private void update() {
		for (int i = member.length - 1; i >= 0; i--)
			map[member[i].getY()][member[i].getX()] = member[i].getShape();
	}
	
	private void clear() {
		for (int i = 0; i < member.length; i++)
			map[member[i].getY()][member[i].getX()] = '-';
	}
	
	private void draw() {
		System.out.println();
		for (int i = 0; i < MAX_Y; i++) {
			for (int j = 0; j < MAX_X; j++) 
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
	
	private boolean doesEnd() {
		if (member[0].collide(member[1])) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}

}
