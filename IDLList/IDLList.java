/*
 * 
 * @author Zikang Sheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 03/08/2020
 *
 */

import java.util.ArrayList;

public class IDLList<E> {
	private static class Node<F>{
		//Data fields
		F data;
		Node<F> next;
		Node<F> prev;
		
		//Constructors
		Node(F elem){
			data = elem;
			next = null;
			prev = null;
		}
		
		Node(F elem, Node<F> prev, Node<F> next){
			data = elem;
			this.next = next;
			this.prev = prev;
		}
	}
	
	//Data fields
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;
	
	//Constructor
	public IDLList() {
		head = null;
		tail = null;
		size = 0;
		indices = new ArrayList<Node<E>>();
		
	}
	
	/**
	 * Add element at position index
	 * @param index
	 * @param elem
	 * @return true
	 */
	public boolean add(int index, E elem) {
		if (index > size || index < 0) {
			throw new IllegalStateException("Index out of bound!");
		}
		if (index == 0) {
			this.add(elem);
		}
		else if (index == size) {
			this.append(elem);
		}
		else {
			Node<E> temp = new Node<E>(elem, indices.get(index-1),indices.get(index));
			indices.get(index-1).next = temp;
			indices.get(index).prev = temp;
			indices.add(index, temp);
			size++;
		}
		return true;
	}
	
	/**
	 * Add element at the head
	 * @param elem
	 * @return true
	 */
	public boolean add(E elem) {
		if (head == null) {
			head = new Node<E>(elem);
			tail = head;
			indices.add(head);
			size++;
		}
		else {
			Node<E> temp = new Node<E>(elem, null, head);
			head.prev = temp;
			head = head.prev;
			indices.add(0, head);
			size++;
		}
		return true;
	}
	
	/**
	 * Add element at the tail
	 * @param elem
	 * @return true
	 */
	public boolean append(E elem) {
		if (tail == null) {
			this.add(elem);
		}
		else {
			Node<E> temp = new Node<E>(elem, tail, null);
			tail.next = temp;
			tail = tail.next;
			indices.add(tail);
			size++;
		}
		return true;
	}
	
	/**
	 * Display the element at position index
	 * @param index
	 * @return element at position index
	 */
	public E get(int index) {
		if (size==0) {
			throw new IllegalStateException("Empty list!");
		}
		else if (index<0 || index>=size) {
			throw new IllegalStateException("Index out of bound!");
		}
		return indices.get(index).data;
	}
	
	/**
	 * Display the element at the head
	 * @return element at the head
	 */
	public E getHead() {
		if (head == null) {
			throw new IllegalStateException("Empty list!");
		}
		return head.data;
	}
	
	/**
	 * Display the element at the tail
	 * @return element at the tail
	 */
	public E getLast() {
		if (tail == null) {
			throw new IllegalStateException("Empty list!");
		}
		return tail.data;
	}
	
	/**
	 * Display the size of the list
	 * @return size of the list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Remove the element at the head
	 * @return element at the head
	 */
	public E remove() {
		if (head == null) {
			throw new IllegalStateException("Empty list!");
		}
		if (head == tail) {
			E temp = head.data;
			head = null;
			tail = null;
			indices.remove(0);
			size--;
			return temp;
		}
		E temp = head.data;
		head.next.prev = null;
		head = head.next;
		indices.remove(0);
		size--;
		return temp;
	}
	
	/**
	 * Remove the element at the tail
	 * @return element at the tail
	 */
	public E removeLast() {
		if (tail == null) {
			throw new IllegalStateException("Empty List!");
			}
		if (tail == head) {
			return this.remove();
		}
		E temp = tail.data;
		tail.prev.next = null;
		tail = tail.prev;
		indices.remove(size-1);
		size--;
		return temp;
	}
	
	/**
	 * Remove the element at position index
	 * @param index
	 * @return element at position index
	 */
	public E removeAt(int index) {
		if (index >= size || index < 0) {
			throw new IllegalStateException("Index out of bound!");
		}
		if (index == 0 || head == tail) {
			return this.remove();
		}
		else if (index == size-1) {
			return this.removeLast();
		}
		else {
			E temp = indices.remove(index).data;
			indices.get(index-1).next = indices.get(index);
			indices.get(index).prev = indices.get(index-1);
			size--;
			return temp;
		}
	}
	
	/**
	 * Remove the first occurrence of the element in the list
	 * @param elem
	 * @return true; false, if the element does not exist
	 */
	public boolean remove(E elem) {
		for (int i=0; i<size; i++) {
			if (indices.get(i).data == elem) {
				this.removeAt(i);
				return true;
			}
		}
		return false;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		Node<E> current = head;
		while (current!=null) {
			s.append(current.data.toString() + ", ");
			current = current.next;
		}
		s.append("]");
		
		return s.toString();
	}
}
