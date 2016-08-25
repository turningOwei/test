package designPattern.adapter.classAdapter;

public interface Target {
	/**
	 * 这是源类Adaptee的方法
	 */
	public void sampleOperation1();
	/**
	 * 这是源类Adaptee没有的方法
	 */
	public void sampleOperation2();
	
	public void request();  
}
