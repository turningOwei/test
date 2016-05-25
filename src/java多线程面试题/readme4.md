4.如何创建线程?
有两种创建线程的方法：一个是实现Runnable接口，然后传递给Thread构造函数，二是创建Thread类。本质还是native方法生成。

#以下摘自java虚拟机并发编程#
旧api缺点:线程不允许重新启动,所以一旦线程执行完了就必须把Thread类的实例丢掉。
现在由Doug Lea等人牵头开发的java.util.concurrent包中下一代并发api已经很好的替代了旧线程api
.以前代码中使用Thread类及其方法的地方,现在都可以考虑用ExecutorService类及其相关类来替换。
.如果想要更好得控制加锁的过程,则最好使用Lock接口及其方法。
.以前代码中使用wait/notify方法的地方,现在都可以使用像CyclicBarrier和CountdownLatch这样的同步工具来替换。