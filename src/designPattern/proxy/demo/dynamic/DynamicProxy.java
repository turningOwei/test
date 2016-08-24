package designPattern.proxy.demo.dynamic;

public class DynamicProxy {
	public static void main(String[] args) {
		BusinessFooImpl bfoo = new BusinessFooImpl();
		BusinessFoo bf = (BusinessFoo) BusinessImplProxy.factory(bfoo);
		bf.foo();
		System.out.println();
	}
}
