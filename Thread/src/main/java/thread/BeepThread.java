package thread;

import java.awt.*;

public class BeepThread extends Thread {
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
