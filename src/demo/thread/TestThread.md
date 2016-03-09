#1 public void start()
#使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
#2	public void run()
#如果该线程是使用独立的 Runnable 运行对象构造的，则调用该 Runnable 对象的 run 方法；否则，该方法不执行任何操作并返回。
#3	public final void setName(String name)
#改变线程名称，使之与参数 name 相同。
#4	public final void setPriority(int priority)
# 更改线程的优先级。
#5	public final void setDaemon(boolean on)
#将该线程标记为守护线程或用户线程。
#6	public final void join(long millisec)
#等待该线程终止的时间最长为 millis 毫秒。
#7	public void interrupt()
#中断线程。
#8	public final boolean isAlive()
#测试线程是否处于活动状态。