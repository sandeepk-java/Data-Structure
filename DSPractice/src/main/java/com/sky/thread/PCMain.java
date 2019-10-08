package com.sky.thread;

import java.util.ArrayList;
import java.util.List;

public class PCMain {
	
	public static void main(String[] args) {
		final PC pc = new PC();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		
	}
	

}

class PC{
	int capacity = 2;
	List<Integer> list = new ArrayList<>();
	
	synchronized public void produce() throws InterruptedException{
		int i=0;
		while(true){
			if(list.size()==capacity)
				wait();
			while(list.size()<capacity){
				System.out.println("Producing: "+i);
				list.add(i++);
				Thread.sleep(1000);
			}
			notify();
		}
	}
	
	synchronized public void consume() throws InterruptedException{
		int i=0;
		while(true){
			if(list.isEmpty())
				wait();
			while(!list.isEmpty()){
				System.out.println("Consuming: "+list.remove(i));
				Thread.sleep(1000);
			}
			notify();
		}
	}
}
