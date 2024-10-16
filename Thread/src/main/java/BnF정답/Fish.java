package BnF정답;
public class Fish extends GameObject {
	public Fish(int x, int y, int distance) {
		super(x, y, distance); 
	}
	 
	@Override
	public void move() { // �� �� �����̴� ���� ����
		int n = (int)(Math.random()*5); // 0,1,2,3,4 �߿��� 0�� ��� + ����, 1�� ��� - ����, ������ ����
		if(n==0) x += distance;
		else if(n==1) x -= distance;

		if(x < 0) x=0;
		if(x >= Game.MAX_X) x = Game.MAX_X - 1;
		 
		n = (int)(Math.random()*5);
		if(n==0) y += distance;
		else if(n==1) y -= distance;

		if(y < 0) y=0;
		if(y >= Game.MAX_Y) y= Game.MAX_Y - 1;
	}

	@Override
	public char getShape() { // Fish�� ��� ����
		return '@';
	}
}
