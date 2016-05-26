package java多线程面试题.demo11;

public class ThreadJoinExample {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable(), "t1");
		Thread t2 = new Thread(new MyRunnable(), "t2");
		Thread t3 = new Thread(new MyRunnable(), "t3");

		t1.start();
		// start second thread after waiting for 2 seconds or if it's dead
		try {
			t1.join(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();

		// start third thread only when first thread is dead
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t3.start();

		// let all threads finish execution before finish main thread

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("all threads are dead,exiting main thread");
	}

}
