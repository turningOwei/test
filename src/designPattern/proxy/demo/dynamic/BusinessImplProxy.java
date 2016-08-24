package designPattern.proxy.demo.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BusinessImplProxy implements InvocationHandler {
	private Object obj;

	BusinessImplProxy() {
	}

	BusinessImplProxy(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		doBefore();
		Object result = method.invoke(obj, args);
		doAfter();
		return result;
	}

	public void doBefore() {
		System.out.println("do something before Business Logic");
	}

	public void doAfter() {
		System.out.println("do something after Business Logic");
	}

	public static Object factory(Object obj) {
		Class cls = obj.getClass();
		return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(),
				new BusinessImplProxy(obj));
	}
}
