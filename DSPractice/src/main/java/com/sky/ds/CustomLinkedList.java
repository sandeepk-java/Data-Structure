package com.sky.ds;

/**
 * Linked list implementation
 * @author sandeepkumar
 *
 */
public class CustomLinkedList {
	private Node header;
	
	/**
	 * Insert new element into the linked list
	 * @param value
	 */
	public void add(int value){
		Node node = new Node(value);
		if(header==null)
			header = node;
		else{
			Node prevNode = null;
			Node temp = header;
			while(temp!=null){
				prevNode = temp;
				temp = temp.getNext();
			}
			prevNode.setNext(node);
		}
	}
	
	/**
	 * Removes an element from the linked list and return boolean value.
	 * @param value
	 * @return
	 */
	public boolean remove(int value){
		boolean found = false;
		if(header==null)
			throw new NullPointerException("Can not remove element from empty list.");
		else{
			if(header.getValue()==value){
				header = header.getNext();
				found = true;
			} else {
				Node prev = header;
				Node temp = prev;
				while(temp!=null){
					if(temp.getValue()==value){
						prev = temp.getNext();
						found = true;
						break;
					}
					prev = temp;
					temp = temp.getNext();
				}
			}
		}
		return found;
	}
	
	/**
	 * Add an element at the beginning of the list
	 * @param value
	 */
	public void addAtBeginning(int value){
		Node node = new Node(value);
		node.setNext(header);
		header = node;
	}
	
	/**
	 * Add an element at the end of the list 
	 * @param value
	 */
	public void addAtLast(int value){
		Node node = new Node(value);
		if(header==null)
			header = node;
		else{
			Node temp = header;
			while(temp.getNext()!=null){
				temp = temp.getNext();
			}
			temp.setNext(node);
			
		}
	}
	
	/**
	 * Removes an element from the beginning of the list and return the removed element
	 * @return
	 */
	public int removeFromBeginning(){
		Node temp = header;
		if(header==null)
			throw new NullPointerException("Can not remove element from empty list.");
		else{
			header = header.getNext();
			temp.setNext(null);
		}
		return temp.getValue();
	}
	
	/**
	 * Removes the last element from the list and return the removed element value
	 * @return
	 */
	public int removeFromEnd(){
		Node temp = header;
		int value;
		if(header==null)
			throw new NullPointerException("Can not remove element from empty list.");
		else{
			Node prev = temp;
			while(temp.getNext()!=null){
				prev = temp;
				temp = temp.getNext();
			}
			value = temp.getValue();
			prev.setNext(null);
		}
		return value;
	}
	

	@Override
	public String toString() {
		return "" + header + "";
	}
	
	

}
