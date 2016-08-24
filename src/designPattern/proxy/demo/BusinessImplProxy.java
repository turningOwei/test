package designPattern.proxy.demo;

public class BusinessImplProxy implements Business {
	private BusinessImpl bi;

	@Override
	public void doAction() {
		if (bi == null) {
			bi = new BusinessImpl();
		}
		doBefore();
		bi.doAction();
		doAfter();
	}

	public void doBefore() {
		System.out.println("前置处理！");
	}

	public void doAfter() {
		System.out.println("后置处理！");
	}
}

class Test {
	public static void main(String[] args) {
		// 引用变量定义为抽象角色类型
		Business bi = new BusinessImplProxy();
		bi.doAction();
	}
}
