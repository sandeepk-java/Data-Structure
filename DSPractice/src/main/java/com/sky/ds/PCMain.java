package com.sky.ds;

import java.util.ArrayList;
import java.util.List;

public class PCMain {

	public static void main(String[] args) {
		PC pc = new PC();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
					pc.produce();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
					pc.consume();
			}
		});
		t1.start();
		t2.start();

	}
	

}

class PC{
	int size = 2;
	List<Integer> list = new ArrayList<>(2);
	static int count = 0;
	
	public void produce(){
		synchronized (this) {
			if(list.size()==size){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			while(list.size()<size){
				list.add(count);
				System.out.println("Producing: "+count++);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notify();
			
		}
		
		
	}
	
	public void consume(){
		synchronized (this) {
			if(list.isEmpty()){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while(!(list.isEmpty())){
				for(int i=0;i<list.size();i++){
					System.out.println("Consuming: "+list.get(i));
					list.remove(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			notify();
		}
	}
}
