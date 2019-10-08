package com.sky.ds;

public class Node {
	private int value;
	private Node next;
	
	public Node(){}
	
	public Node(int value) {
		this.value = value;
		next = null;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node node) {
		this.next = node;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", next=" + next + "]";
	}

}
