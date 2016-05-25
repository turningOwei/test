5.有哪些不同的线程生命周期？
当我们在java程序中新建一个线程时，它的状态是New。
当调用线程的start()方法时，状态被改变为Runnable。
线程调度器会为Runnable线程池中的线程分配CPU时间并且讲它们的状态改变为Running。
其他的线程状态还有Waiting，Blocked和Dead。

#Life Cycle of Thread – Understanding Thread States in Java#
http://www.journaldev.com/1044/life-cycle-of-thread-understanding-thread-states-in-java