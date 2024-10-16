package thread;

public class InterruptedException {
	public static void main(String[] args) {
		Thread thread = new PrintThread2();
		thread.start();
		
		try {thread.sleep(1000);} catch (Exception e) {}
		
		thread.interrupt();
	}
}