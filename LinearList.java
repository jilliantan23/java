/**
   *  Program #2
   *  Implementing Stacks and Queues Using Doubly Linked List
   *  CS310-1
   *  10 March 2019
   *  @author  Jillian Tan cssc1515
   */
   
package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class LinearList<E extends Comparable<E>> implements LinearListADT<E>, Iterable<E> {
	
	@SuppressWarnings("hiding")
	private class Node<E>{
		E data;
		Node<E> next;
		Node<E> previous;
	
		public Node(E obj) {
			data = obj;
			next = null;
			previous = null;
		}
	}
	
	Node<E> head;
	Node<E> tail;
	Node<E> curr; //points at the current node
	int currentSize = 0;
	int modificationCounter;
	
	public LinearList() {
		currentSize = 0;
		head = tail = null;
		curr = null;
		modificationCounter = 0;
	}
	
	/* Adds the Object obj to the beginning of list and returns true if the list * is not full.
	* returns false and aborts the insertion if the list is full.
	*/
	public boolean addFirst(E obj) { 
		Node<E> newNode = new Node<E>(obj);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			currentSize++;
			modificationCounter++;
			return true;
		}
		newNode.next = head;
		head.previous = newNode;
		head = newNode;
		currentSize++;
		modificationCounter++;
		return true;
	}
	
	
	/* Adds the Object obj to the end of list and returns true if the list is * not full.
	* returns false and aborts the insertion if the list is full.
	*/
	public boolean addLast(E obj) {
		Node<E> newNode = new Node<E>(obj);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			currentSize++;
			modificationCounter++;
			return true;
		}
		
		tail.next = newNode;
		newNode.previous = tail;
		tail = newNode;
		currentSize++;
		modificationCounter++;
		return true;
	}
	
	
	/* Removes and returns the parameter object obj in first position in list * if the list is not empty, null if the list is empty.
	*/
	public E removeFirst() {
		if (isEmpty()) { //empty list
			return null;
		}
		E temp = head.data;
		head = head.next;
		currentSize--;
		modificationCounter++;
		if (currentSize == 0) { //
			head = tail = null;
		}
		return temp;
	}
	
	
	/* Removes and returns the parameter object obj in last position in list if * the list is not empty, null if the list is empty.
	*/
	public E removeLast() {
		if (isEmpty()) { //if list is empty
			return null;
		}
		if (head == tail) { //if list has a single element
			return removeFirst();
		}
		else {
			E temp = tail.data;
			tail = tail.previous;
			tail.next = null;
			currentSize--;
			modificationCounter++;
			return temp;
		}
		
	}
	
	/* Removes and returns the parameter object obj from the list if the list * contains it, null otherwise. The ordering of the list is preserved.
	        
	* The list may contain duplicate elements. This method removes and returns * the first matching element found when traversing the list from first
	* position. Note that you may have to shift elements to fill in the slot
	* where the deleted element was located.
	*/
	public E remove(E obj) {
		if (isEmpty()) {
			return null;
		}
		if (head == tail) {
			return removeFirst();
		}
		if(((Comparable<E>)head.data).compareTo(obj) == 0 ){
			return removeFirst();
		}
		if(((Comparable<E>)tail.data).compareTo(obj) == 0 ){
			return removeLast();
		}
		else {
			Node<E> current = head;
			E temp = null;
			while (current != null) {
				if(((Comparable<E>)current.data).compareTo(obj) == 0 ){ //obj is in the list
					temp = current.data;
					current.previous.next = current.next;
					current.next.previous = current.previous;
					currentSize--;
					modificationCounter++;
					return temp;
				}
				current = current.next;
			}	
		}
		return null;
	}
	
	
	    /* Returns the first element in the list, null if the list is empty.
	     * The list is not modified.
	     */
	public E peekFirst() {
		return head.data;
	}
	
	
	    /* Returns the last element in the list, null if the list is empty.
	     * The list is not modified.
	     */
	public E peekLast() {
		if (isEmpty()) {
			return null;
		}
		else
			return tail.data;
	}
	
	
	    /* Returns true if the parameter object obj is in the list, false otherwise.
	     * The list is not modified.
	     */
	public boolean contains(E obj) {
		Node<E> current = head;
		while (current != null) {
			if( ((Comparable<E>)current.data).compareTo(obj) == 0 ){ //obj is in the list
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	
	/* Returns the element matching obj if it is in the list, null otherwise. * In the case of duplicates, this method returns the element closest to * front. The list is not modified.
	*/
	public E find(E obj) {
		if (contains(obj) == false) {
			return null;
		}
		else {
			Node<E> current = head;
			while (current != null) {
				if( ((Comparable<E>)current.data).compareTo(obj) == 0 ){ //obj is in the list
					return current.data;
				}
				current = current.next;
			}
		}
		return null;
	}

	/* The list is returned to an empty state. */
	public void clear() {
		head = tail = null;
		currentSize = 0;
		modificationCounter++;
	}
	
	
	    /* Returns true if the list is empty, otherwise false
	     */
	public boolean isEmpty() {
		if (head != null) {
			return false;
		}
		return true;
	}
	
	    /* Returns true if the list is full, otherwise false
	     */
	public boolean isFull() {
		return false;
	}
	
	
	/* Returns the number of Objects currently in the list. */
	public int size() {
		return currentSize;
	}
	
	    /* Returns an Iterator of the values in the list, presented in the same
	     * order as the underlying order of the list. (front first, rear last)
	     */
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}
	
	class IteratorHelper implements Iterator<E> {
		Node<E> count;
		long stateCheck;
		
		public IteratorHelper() {
			stateCheck = modificationCounter;
			count = head;
		}
		
		@Override
		public boolean hasNext() {
			if (stateCheck != modificationCounter) 
				throw new ConcurrentModificationException();
			if (count != null)
				return true;
			else
				return false;
		}
		public E next() {
			if (!hasNext()) 
				throw new NoSuchElementException();
			E iteratorData = count.data;
			count = count.next;
			return iteratorData;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
