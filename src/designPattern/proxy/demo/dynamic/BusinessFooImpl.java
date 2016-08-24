package designPattern.proxy.demo.dynamic;

//真实角色：真正实现业务逻辑方法
public class BusinessFooImpl implements BusinessFoo {

	@Override
	public void foo() {
		System.out.println("BusinessFooImpl.foo()");
	}

}
