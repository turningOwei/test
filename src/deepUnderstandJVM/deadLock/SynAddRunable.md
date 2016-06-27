造成死锁的原因是Integer.valueOf()方法基于减少对象创建次数和节省内存的考虑,[-128,127]之间的数字会被缓存
(默认值,取决于java.lang.Integer.IntegerCache.high参数的设置),当valueOf()方法传入参数在这个范围内,将
直接返回缓存中的对象。