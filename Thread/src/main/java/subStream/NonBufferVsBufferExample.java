package subStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.plaf.synth.SynthButtonUI;

import org.apache.coyote.http11.filters.BufferedInputFilter;

public class NonBufferVsBufferExample {

	public static void main(String[] args) throws Exception {
		String originalFilePath1 = NonBufferVsBufferExample.class.getResource("soodal.jpg").getPath();
		String targetFilePath1 = "C:/Temp/soodal.jpg";
		FileInputStream fis = new FileInputStream(originalFilePath1);
		FileOutputStream fos = new FileOutputStream(targetFilePath1);
		
		String originalFilePath2 = NonBufferVsBufferExample.class.getResource("haedal.jpg").getPath();
		String targetFilePath2 = "C:/Temp/haedal.jpg";
		FileInputStream fis2 = new FileInputStream(originalFilePath2);
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		long nonBufferTime = copy(fis,fos);
		System.out.println("버퍼 사용 하지 않을 때:\t" + nonBufferTime + "ns");
		long BufferTime = copy(bis,bos);
		System.out.println("버퍼 사용 할 때:\t" + BufferTime + "ns");
		
		fis.close();
		fos.close();
		bis.close();
		bos.close();
	}

	static int data = -1;
	public static long copy(InputStream is, OutputStream os) throws Exception{
		long start = System.nanoTime();
		while(true) {
			data = is.read();
			if(data == -1)	break;
			os.write(data);
		}
		os.flush();
		long end = System.nanoTime();
		return (end - start);
	}
}
