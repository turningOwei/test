package designPattern.proxy;

public class Proxy implements Subject {
	private Subject subject;

	public Proxy() {
		super();
		subject = new RealSubject();
	}

	@Override
	public void operate() {
		System.out.println("before operate......");
		subject.operate();
		System.out.println("after operate......");
	}

}
