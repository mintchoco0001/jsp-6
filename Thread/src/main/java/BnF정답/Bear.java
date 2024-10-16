package BnF정답;

import java.util.Scanner;

public class Bear extends GameObject {
	private Scanner scanner;
	public Bear(int x, int y, int distance) {
		super(x, y, distance);
		scanner = new Scanner(System.in);
	}
	
	@Override
	public void move() {
		System.out.print("����(a), �Ʒ�(s), ��(d), ������(f) >> ");
		char c;
		c = scanner.next().charAt(0);
		switch(c) {
			case 'a' : // left
				x--; 
				if(x < 0) x = 0;
				break;
			case 'f' : // right
				x++; 
				if(x >= Game.MAX_X) x = Game.MAX_X - 1;
				break;
			case 'd' : // up
				y--; 
				if(y < 0) y = 0;
				break;
			case 's' : // down
				y++; 
				if(y >= Game.MAX_Y) y = Game.MAX_Y - 1;
				break;
		}		
	}
	
	@Override
	public char getShape() { // Bear�� ��� ����
		return 'B';
	}
}
