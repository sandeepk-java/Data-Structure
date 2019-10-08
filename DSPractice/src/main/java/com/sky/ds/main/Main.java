package com.sky.ds.main;

import java.util.*;

import com.sky.ds.CustomLinkedList;

public class Main {

	public static void main(String[] args) {
		Set<Character> c = new HashSet<>();
		char c1 = 'a';
		char c2 = 'a';
		if(c1==c2)
			System.out.println(true);
		else System.out.println(false);
		
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
		System.out.println(list.size());
	}

}
