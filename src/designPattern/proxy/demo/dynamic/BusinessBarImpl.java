package designPattern.proxy.demo.dynamic;

public class BusinessBarImpl implements BusinessBar {

	@Override
	public String bar(String message) {
		System.out.println("BusinessBarImpl.bar()");
		return message;
	}

}
