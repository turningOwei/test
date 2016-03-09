package demo.thread.TwoWriting;

public class TestThread extends Thread {
	@Override
	public void run() {
		System.out.println("11...");
	}

	public static void main(String[] args) {
		TestThread tt = new TestThread();
		Thread t = new Thread(tt);
		t.start();
		// start和run区别参考demo.thread.StartCompareRun
	}
}
