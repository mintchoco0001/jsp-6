package thread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.xml.sax.InputSource;

public class WriteExmaple {

	public static void main(String[] args) throws Exception {
		//OutputStream os = new FileOutputStream("C://Temp/test1.txt");
//		byte a = 10;
//		byte b = 20;
//		byte c = 30;
		
//		os.write(a);
//		os.write(b);
//		os.write(c);
//		OutputStream os = new FileOutputStream("C://Temp/test2.txt");
//		
//		byte[] array = {10, 20, 30};
//		os.write(array);
//		
//		os.flush();
//		os.close();
		
//		InputStream is = new FileInputStream("C://Temp/test1.txt");
//		while(true) {
//			int data = is.read();
//			if(data == -1) {
//				break;
//			}
//			System.out.println(data);
//			
//		}
//		is.close();
		
//		Writer writer = new FileWriter("C://Temp/test3.txt");
//		
//		char a = 'A';
//		char b = 'B';
//		char c = 'C';
//		
//		writer.write(a);
//		writer.write(b);
//		writer.write(c);
//		
//		writer.flush();
//		writer.close();

		Reader reader = new FileReader("C://Temp/test3.txt");
		
		while(true) {
			int data = reader.read();
			if(data == -1) {
				break;
			}
			System.out.println((char)data);
		}
		reader.close();
	}

}
