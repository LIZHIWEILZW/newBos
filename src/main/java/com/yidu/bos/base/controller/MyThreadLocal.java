package com.yidu.bos.base.controller;

public class MyThreadLocal {

	public static void main(String[] args) {
		/*MyRunnable m=new MyRunnable();
		Thread thread=new Thread(m);
		thread.start();*/
		
		final ThreadLocal<String> threadLocal=new ThreadLocal();
		threadLocal.set("adsa");
		
		new Thread(){
			public void run(){
				System.out.println("threadLocal:"+threadLocal.get());
			};
		}.start();
		
		
	}

}

/*class MyRunnable implements Runnable{

	@Override
	public void run() {
	}
	
}*/
