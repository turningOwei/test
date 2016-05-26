package java多线程面试题.demo11;

public class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out
				.println("Thread started:" + Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread ended:" + Thread.currentThread().getName());
	}

}
