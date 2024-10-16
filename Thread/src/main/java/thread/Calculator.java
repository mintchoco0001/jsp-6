package thread;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
//	이렇게 적으면 두 쓰레드가 처리하는 값이 정확하게 표시가 안될수도 있음
//	public void setMemory(int memory) {
//		this.memory = memory;
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {	}
//		System.out.println(Thread.currentThread().getName() + " : " +this.memory);
//	}
	
//	synchronized는 쓰레드 하나가 처리 될 때 다른 쓰레드가 건드리지 못하게 해줌
//	이걸 임계지점 설정 이라고 한다
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (Exception e) {	}
		System.out.println(Thread.currentThread().getName() + " : " +this.memory);
	}
}