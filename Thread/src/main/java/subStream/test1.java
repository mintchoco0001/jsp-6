package subStream;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test1 {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		String a = " ";
		Writer writer = new FileWriter("C:/Temp/test1.txt", true);
		while (a != "") {
			System.out.println("데이터 입력 : ");
			a = s.nextLine();
			writer.write(a+"\n");
			writer.flush();
		}
		writer.write("\n\n");
		writer.close();
	}
}
