package BnF;

import java.util.Random;
import java.util.Scanner;

public class Game {
    int x = 20;
    int y = 10;
    public String[][] set = new String[y][x];
    String val = "-";
    int bx = 0, by = 0; // B의 위치
    int ax = 5, ay = 5; // @의 위치
    Random r = new Random();

    // 배열 초기화 메서드
    public void initializeArray() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                set[i][j] = val;
            }
        }
        set[by][bx] = "B"; // 첫 번째 요소를 "B"로 설정
        set[ay][ax] = "@"; // 5.5에 @로 표시
    }

    // 배열 출력 메서드
    public void printArray() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(set[i][j]);
            }
            System.out.println();
        }
    }

    // B 이동 메서드
    public void moveB(char direction) {
        set[by][bx] = val; // 현재 위치를 초기화
        switch (direction) {
            case 'w':
                if (by > 0) by--;
                break;
            case 'a':
                if (bx > 0) bx--;
                break;
            case 's':
                if (by < y - 1) by++;
                break;
            case 'd':
                if (bx < x - 1) bx++;
                break;
        }
        set[by][bx] = "B"; // 새로운 위치에 B 설정
    }

    // @ 랜덤 이동 메서드
    public void moveA() {
        set[ay][ax] = val; // 현재 위치를 초기화
        int direction = r.nextInt(10);
        switch (direction) {
            case 0: // 위로 이동
                if (ay > 0) ay--;
                break;
            case 1: // 아래로 이동
                if (ay < y - 1) ay++;
                break;
            case 2: // 왼쪽으로 이동
                if (ax > 0) ax--;
                break;
            case 3: // 오른쪽으로 이동
                if (ax < x - 1) ax++;
                break;
        }
        set[ay][ax] = "@"; // 새로운 위치에 @ 설정
    }
    
    public void finish() {
    	 set[by][bx] = "B"; // 첫 번째 요소를 "B"로 설정
         set[ay][ax] = "@"; // 5.5에 @로 표시
         if(set[by][bx]== "B" && set[ay][ax]=="@") {
        	 set[ay][ax] = "-";
        	 System.out.println("게임 끝");
         }
    }

    public static void main(String[] args) {
        Game g = new Game(); // Game 객체 생성
        Scanner scanner = new Scanner(System.in);

        g.initializeArray(); // 배열 초기화
        g.printArray(); // 배열 출력

        while (true) {
            System.out.print("w, a, s, d 중 하나를 입력하세요: ");
            char input = scanner.next().charAt(0);
            g.moveB(input); // B 이동
            g.moveA(); // @ 랜덤 이동
            g.printArray(); // 배열 출력
        }
    }
}
