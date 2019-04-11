package com.sky.ds.main;

import com.sky.ds.CustomLinkedList;

public class Main {

	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		list.add(2);
		list.add(5);
		list.add(7);
		System.out.println(list);
		list.remove(2);
		System.out.println(list);
		list.remove(2);
		System.out.println(list.removeFromEnd());
		System.out.println(list);
		list.addAtLast(11);
		System.out.println(list);
	}

}
