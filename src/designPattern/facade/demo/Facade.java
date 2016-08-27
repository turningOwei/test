package designPattern.facade.demo;

import designPattern.facade.demo.module.ModuleA;
import designPattern.facade.demo.module.ModuleB;
import designPattern.facade.demo.module.ModuleC;

//门面角色类
public class Facade {
	// 示意方法,满足客户端需要的功能
	public void test() {
		ModuleA a = new ModuleA();
		a.testA();
		ModuleB b = new ModuleB();
		b.testB();
		ModuleC c = new ModuleC();
		c.testC();
	}
}
