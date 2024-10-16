package subStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

public class test2 {

	public static void main(String[] args) throws Exception {

		FileInputStream input = new FileInputStream("C:/Temp/music1.txt");
		InputStreamReader reader = new InputStreamReader(input, "UTF-8");
		BufferedReader br = new BufferedReader(reader);

		FileInputStream input2 = new FileInputStream("C:/Temp/music2.txt");
		InputStreamReader reader2 = new InputStreamReader(input2, "UTF-8");
		BufferedReader br2 = new BufferedReader(reader2);

		Writer writer = new FileWriter("C:/Temp/musicMix.txt", true);

		int ch;
		int ch2;
		try {

			while ((ch = br.read()) != -1) {
				System.out.print((char) ch);
				writer.write(ch);
			}

			System.out.println("\t\n");
			writer.write("\n\n");

			while ((ch2 = br2.read()) != -1) {
				System.out.print((char) ch2);
				writer.write(ch2);
			}

			writer.flush();
			writer.close();

		} catch (IOException e) {
			System.out.println("잘못 입력함.");
		}

	}

}
