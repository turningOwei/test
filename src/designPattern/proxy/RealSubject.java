package designPattern.proxy;

public class RealSubject implements Subject {

	@Override
	public void operate() {
		System.out.println("realsubject operatestarted......");
	}

}
