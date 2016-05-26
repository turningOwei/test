package java虚拟机并发编程.chapter2.chapter2_4;

public class SequentialPrimeFinder extends AbastractPrimeFinder{

	@Override
	public int countPrimes(int number) {
		return countPrimesInRange(1,number);
	}
	
	public static void main(String[] args) {
		new SequentialPrimeFinder().timeAndCompute(10000000);
	}

}
