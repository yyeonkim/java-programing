package week04;

public class Game {
	public static final int MAX_X = 20;
	public static final int MAX_Y = 10;
	private char[][] map = new char [MAX_Y][MAX_X];
	private GameObject[] member = new GameObject[2];
	// private int state; // 0: 게임 중, 1: Bear이 win, 2: Fish가 win
	
	public Game() {
		for (int i = 0; i < MAX_Y; i++)
			for (int j = 0; j < MAX_X; j++)
				map[i][j] = '-';
		
		member[0] = new Bear(0, 0, 1);
		member[1] = new Fish(5, 5, 1);
		// state = 0; // 게임 중
	}
	
	public void run() {
		System.out.println("** Bear의 Fish 먹기 게임을 시작합니다. **");
		
		update(); // 초기 좌표에 따라 맵 설정
		draw(); // 초기 게임 맵 보여주기
		
		while (!doesEnd()) {
			clear(); // 현재 맵 지움
			for (int i = 0; i < member.length; i++)
				member[i].move();
			update();
			draw();
		}
		System.out.println("Bear 승!");
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
