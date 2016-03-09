package demo.thread.TwoWriting;

public class TestRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("11...");
	}

	public static void main(String[] args) {
		TestRunnable tr = new TestRunnable();
		Thread t = new Thread(tr);
		t.start();
		// start和run区别参考demo.thread.StartCompareRun
	}
}
