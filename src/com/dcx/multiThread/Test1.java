package com.dcx.multiThread;

/**
 * ����1�ͷ���2���ڶ�����������Ҳ���ǲ�ͬ���̲߳���ͬһ��������ֻ����һ���߳̿���ִ��ͬ��������ֻ����һ��ִ�У���һ���ȴ���
 * �����������ͬ�Ķ���������ֱ�ӻ���Ӱ�졣
 * 	ִ�н����
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
	����3�ͷ���4�����������������������һ�����������Բ�������ͬ�Ķ����ǲ�ͬ�Ķ������ͬ��������ֻ����һ��ִ�У���һ���ȴ���
	ִ�н����
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
	��ͬ�߳�ִ�з���1������3,����ǣ�
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
	�ɼ������Ͷ������ǻ���Ӱ��ġ�
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
