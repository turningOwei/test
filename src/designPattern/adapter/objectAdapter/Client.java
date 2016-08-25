package designPattern.adapter.objectAdapter;

import designPattern.adapter.classAdapter.Adaptee;
import designPattern.adapter.classAdapter.ConcreteTarget;
import designPattern.adapter.classAdapter.Target;

public class Client {
	public static void main(String[] args) {
		Target con = new ConcreteTarget();
		con.request();
		
		//需要先创建一个被适配类的对象作为参数
		Target adapter = new Adapter(new Adaptee());
		adapter.request();
	}
}
