package java多线程面试题.demo12;

/**
 * @ClassName: Notifier
 * @Description: TODO()
 * @author weipeng 175408322@qq.com
 * @date 2016年5月26日 下午5:51:08
 *
 */
public class Notifier implements Runnable {

	private Message msg;

	public Notifier(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + "started");
		try {
			Thread.sleep(1000);
			synchronized (msg) {
				msg.setMsg(name + " Notifier work done");
				msg.notify();
				// msg.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
