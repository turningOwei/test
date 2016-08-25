package designPattern.adapter.objectAdapter;

import designPattern.adapter.classAdapter.Adaptee;
import designPattern.adapter.classAdapter.Target;

public class Adapter implements Target {

	@Override
	public void sampleOperation1() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sampleOperation2() {
		// TODO Auto-generated method stub

	}
	
	//直接关联被适配类
	private Adaptee adaptee;
	// 可以通过构造函数传入具体需要适配的被适配类对象 
	public Adapter(Adaptee adaptee){
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		//这里是使用委托的方式完成特殊功能
		this.adaptee.specificRequest();

	}

}
