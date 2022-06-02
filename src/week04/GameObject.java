package week04;

public abstract class GameObject {
	protected int distance; // 한 번 이동 거리
	protected int x, y; // 현재 위치(화면 상의 위치)
	
	// 초기 위치와 이동 거리 설정
	protected GameObject(int x, int y, int distance) {
		System.out.println("GameObject 생성자");
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	// 이 객체가 객체 p와 충돌하면 true 리턴
	public boolean collide(GameObject p) {
		if (this.x == p.getX() && this.y == p.getY())
			return true;
		else
			return false;
	}
	
	protected abstract void move(); // 이동한 새로운 위치 x, y로 변경
	protected abstract char getShape(); // 객체 모양을 나타내는 문자 리턴
}
