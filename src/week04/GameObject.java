package week04;

public abstract class GameObject {
	protected int distance; // �� �� �̵� �Ÿ�
	protected int x, y; // ���� ��ġ(ȭ�� ���� ��ġ)
	
	// �ʱ� ��ġ�� �̵� �Ÿ� ����
	protected GameObject(int x, int y, int distance) {
		System.out.println("GameObject ������");
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
	
	// �� ��ü�� ��ü p�� �浹�ϸ� true ����
	public boolean collide(GameObject p) {
		if (this.x == p.getX() && this.y == p.getY())
			return true;
		else
			return false;
	}
	
	protected abstract void move(); // �̵��� ���ο� ��ġ x, y�� ����
	protected abstract char getShape(); // ��ü ����� ��Ÿ���� ���� ����
}
