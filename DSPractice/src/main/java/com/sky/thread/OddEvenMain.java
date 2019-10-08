package com.sky.thread;

public class OddEvenMain {

	public static void main(String[] args) {
		OddEven oe = new OddEven();
		
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				oe.printOdd();
			}
		});
		
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				oe.printEven();
			}
		});
		
		t1.start();
		t2.start();

	}

}

class OddEven{
	
	int max = 10;
	int start = 1;
	public void printEven(){
		synchronized (this) {
			while(start<max){
				if(start%2==1)
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println("Printing even: "+start++);
				/*try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				notify();
			}
			
		}
	}
	
	public void printOdd(){
		synchronized (this) {
			while(start<max){
				if(start%2==0)
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println("Printing odd: "+start++);
				/*try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				notify();
			}
		}
	}
}
