package com.dcx.multiThread;

/**
 * 方法1和方法2属于对象锁方法，也就是不同的线程操作同一个对象，则只能有一个线程可以执行同步方法。只能有一个执行，另一个等待。
 * 如果是两个不同的对象，则两者直接互不影响。
 * 	执行结果：
	 * 	test2:4
		test2:3
		test2:2
		test2:1
		test2:0
		test1:4
		test1:3
		test1:2
		test1:1
		test1:0
	方法3和方法4属于类锁方法，多个对象公用一个类锁，所以不管是相同的对象还是不同的对象访问同步方法，只能有一个执行，另一个等待。
	执行结果：
		test3:4
		test3:3
		test3:2
		test3:1
		test3:0
		test4:4
		test4:3
		test4:2
		test4:1
		test4:0
	不同线程执行方法1，方法3,结果是：
		test1:4
		test3:4
		test1:3
		test3:3
		test1:2
		test3:2
		test1:1
		test3:1
		test1:0
		test3:0
	可见类锁和对象锁是互不影响的。
 **/
public class Test1 {
	 
	public synchronized void method1(){
		int i = 5;
		while(i-->0){
			System.err.println(Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				 
			}
		}
	}
	public synchronized void method2(){
		int i = 5;
		  while(i-->0){
			  System.err.println(Thread.currentThread().getName() + ":" + i);
			  try {
				Thread.sleep(500);
			} catch (Exception e) {
				 
			}
		  }
	}
	public static synchronized void method3(){
		int i = 5;
		while(i-->0){
			System.err.println(Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				 
			}
		}
	}
	public static synchronized void method4(){
		int i = 5;
		while(i-->0){
			System.err.println(Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				 
			}
		}
	}
	
	public static void main(String[] args) {
		final Test1 a = new Test1();
		final Test1 b = new Test1();
		
		Thread test2 = new Thread(new Runnable() {
			@Override
			public void run() {
				a.method1();  
			}
		},"test1");
		test2.start();
		
		Thread test1 = new Thread(new Runnable() {
			@Override
			public void run() {
				a.method3();  
			}
		},"test3");
		test1.start();
	}


}
