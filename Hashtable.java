/**
 *  Program #4
 *  Dictionary Implementation Using Hash Table
 *  CS310-1
 *  9 May 2019
 *  @author  Jillian Tan cssc1515
*/
package data_structures;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;


//Hash table implementation of DictionaryADT interface using chaining
public class Hashtable<K extends Comparable<K>,V> implements DictionaryADT<K,V> {
	private int currentSize;
	private int maxSize;
	private int tableSize;
	private long modificationCounter;
	private LinkedListDS<DictionaryNode<K,V>>[] list;

	public Hashtable(int n) {
		currentSize = 0;
		maxSize = n;
		modificationCounter = 0;
		tableSize = (int) (maxSize * 1.3f);
		list = new LinkedListDS[tableSize];
		for (int i = 0; i < tableSize; i++) 
			list[i] = new LinkedListDS<DictionaryNode<K,V>>();
	}
	class DictionaryNode<K,V> implements Comparable<DictionaryNode<K,V>> {
		K key;
		V value;
		
		public DictionaryNode(K k, V v) {
			key = k;
			value = v;
		}
		
		public int compareTo(DictionaryNode<K,V> node) {
			return ((Comparable<K>)key).compareTo((K)node.key);		
		}
	}
	
//	public static int hashAdd(String s) {
//		byte[] b = s.getBytes();
//		int hash = SIZE;
//		for (int i = 0; i< s.length(); i++)
//			hash += (b[i]-26);
//		return hash;
//	}
		
	private int getHashCode(K key) {
		return (key.hashCode() & 0x7FFFFFFF) % tableSize;
	}
	
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return list[getHashCode(key)].contains(new DictionaryNode<K,V>(key,null));
	}
	
	public boolean add(K key, V value) {
		if (isFull())
			return false;
		if (list[getHashCode(key)].contains(new DictionaryNode<K,V>(key,null)))
			return false;
		list[getHashCode(key)].addLast(new DictionaryNode<K,V>(key,value));
		currentSize++;
		modificationCounter++;
		// TODO Auto-generated method stub
		return true;
	}

	public boolean delete(K key) {
		if (isEmpty())
			return false;
		if (list[getHashCode(key)].contains(new DictionaryNode<K,V>(key,null))) {
			list[getHashCode(key)].remove(new DictionaryNode<K,V>(key,null));
			currentSize--;
			modificationCounter--;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	public V getValue(K key) {
		DictionaryNode<K,V> tmp = list[getHashCode(key)].find(new DictionaryNode<K,V>(key,null));
		if (tmp == null)
			return null;
		// TODO Auto-generated method stub
		return tmp.value;
	}

	public K getKey(V value) {
		for (int i = 0; i < tableSize; i++) {
			for (DictionaryNode<K,V> n : list[i]) {
				if (((Comparable<V>)n.value).compareTo(value) == 0)
					return n.key;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return currentSize;
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return maxSize == currentSize;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return currentSize == 0;
	}

	public void clear() {
		// TODO Auto-generated method stub
		list = new LinkedListDS[tableSize];
		for (int i = 0; i < tableSize; i++) 
			list[i] = new LinkedListDS<DictionaryNode<K,V>>();
		currentSize = 0;
		modificationCounter++;
	}

	public Iterator<K> keys() {
		return new KeyIteratorHelper();
	}
	
	public Iterator<V> values() {
		return new ValueIteratorHelper();
	}
	
	abstract class IteratorHelper<E> implements Iterator<E>{
		protected DictionaryNode<K,V> [] nodes;
		protected int index;
		protected long modificationCheck;
		
		public IteratorHelper() {
			nodes = new DictionaryNode[currentSize];
			index = 0;
			int j = 0;
			modificationCheck = modificationCounter;
			for (int i = 0; i < tableSize; i++) {
				for(DictionaryNode n : list[i])
					nodes[j++] = n;
			}
			int in, out, k = 1;
			DictionaryNode<K,V> temp = null;
			int size = currentSize;
			
			while (k <= size/3)
				k = k*3+1;
			while (k > 0) {
				for (out = k; out < size; out++) {
					temp = nodes[out];
					in = out;
					while (in > k-1 && nodes[in-k].compareTo(temp) >= 0) {
						nodes[in] = nodes[in-k];
						in -= k;
					}
				nodes[in] = temp;
				}
			k = (k-1)/3;
			}	
		}
		
		public boolean hasNext() {
			if (modificationCheck != modificationCounter)
				throw new ConcurrentModificationException();
			return index < currentSize;
		}
		
		public abstract E next();
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	class KeyIteratorHelper<K> extends IteratorHelper<K>{
		
		public KeyIteratorHelper() {
			super();			
		}
		
		public K next() {
			return (K) nodes[index++].key;
		}
		
	}
	
	class ValueIteratorHelper<V> extends IteratorHelper<V>{
		
		public ValueIteratorHelper() {
			super();
		}
		
		@Override
		public V next() {
			return (V) nodes[index++].value;
		}		
	}
	/*  LinkedList
	 *  Singly linked list
	 *  PKraft Spring 2019
	*/

	private class LinkedListDS<E> implements ListADT<E> {
	    /////////////////////////////////////////////////////////////////
	    class Node<T> {
	        T data;
	        Node<T> next;
	        
	        public Node(T obj) {
	            data = obj;
	            next = null;
	            }
	        }
	    // END CLASS NODE ///////////////////////////////////////////////
	    
	    /////////////////////////////////////////////////////////////////
	    class ListIteratorHelper implements Iterator<E> {        
	        Node<E> index;
	        
	        public ListIteratorHelper() {
	            index = head;
	            }
	            
	        public boolean hasNext() {
	            return index != null;
	            }
	            
	        public E next() {
	            if(!hasNext())
	                throw new NoSuchElementException();
	            E tmp = index.data;
	            index = index.next;
	            return tmp;
	            }
	            
	        public void remove() {
	            throw new UnsupportedOperationException();
	            }
	            
	        }
	    // END CLASS LIST_ITERATOR_HELPER //////////////////////////////
	    
	    
	    private Node<E> head, tail;
	    private int currentSize;
	    
	    public LinkedListDS() {
	        head = tail = null;
	        currentSize = 0;
	        }

	    public void addFirst(E obj) {
	        Node<E> newNode = new Node<E>(obj);
	        if(isEmpty())
	            head = tail = newNode;
	        else {
	            newNode.next = head;            
	            head = newNode;
	            }
	        currentSize++;
	        }
	        
	    public void addLast(E obj) {
	        Node<E> newNode = new Node<E>(obj);
	        if(isEmpty())
	            head = tail = newNode;
	        else {
	            tail.next = newNode;
	            tail = newNode;
	            }
	        currentSize++;
	        }
	        
	    public E removeFirst() {
	        if(isEmpty())
	            return null;
	        E tmp = head.data;
	        head = head.next;
	        if(head == null)
	            head = tail = null;
	        currentSize--;
	        return tmp;
	        }
	        
	    public E removeLast() {
	        if(isEmpty())
	            return null;
	        E tmp = tail.data;
	        if(head == tail) // only one element in the list
	            head = tail = null;
	        else {    
	            Node<E> previous = null, current = head;
	            while(current != tail) {
	                previous = current;
	                current = current.next;
	                }
	            previous.next = null;
	            tail = previous;
	            }
	        
	        currentSize--;
	        return tmp;
	        }
	        
	    public E peekFirst() {
	        if(head == null)
	            return null;
	        return head.data;
	        }
	        
	    public E peekLast() {
	        if(tail == null)
	            return null;
	        return tail.data;
	        }
	        
	    public E find(E obj) {
	        if(head == null) return null;
	        Node<E> tmp = head;
	        while(tmp != null) {
	            if(((Comparable<E>)obj).compareTo(tmp.data) == 0)
	                return tmp.data;
	            tmp = tmp.next;
	            }
	        return null;
	        }        
	        
	    public boolean remove(E obj) {
	        if(isEmpty())
	            return false;
	        Node<E> previous = null, current = head;
	        while(current != null) {
	            if( ((Comparable<E>)current.data).compareTo(obj) == 0) {                
	                if(current == head) 
	                    removeFirst();
	                else if(current == tail) 
	                    removeLast();
	                else {
	                    previous.next = current.next;
	                    currentSize--;
	                    }
	                return true;
	                }
	            previous = current;
	            current = current.next;
	            }
	        return false;
	        }
	     
	// not in the interface.  Removes all instances of the key obj        
	    public boolean removeAllInstances(E obj) {
	        Node<E> previous = null, current = head;
	        boolean found = false;
	        while(current != null) {
	            if(((Comparable<E>)obj).compareTo(current.data) == 0) {
	                if(previous == null) { // node to remove is head
	                    head = head.next;
	                    if(head == null) tail = null;
	                    }
	                else if(current == tail) {
	                    previous.next = null;
	                    tail = previous;
	                    }
	                else 
	                    previous.next = current.next;
	                found = true;
	                currentSize--;
	                current = current.next;
	                }
	            else {
	                previous = current;
	                current = current.next;
	                }
	            } // end while
	        return found;
	        }
	        
	    public void makeEmpty() {
	        head = tail = null;
	        currentSize = 0;
	        }

	    public boolean contains(E obj) {
	        Node current = head;
	        while(current != null) {
	            if( ((Comparable<E>)current.data).compareTo(obj) == 0)
	                return true;
	            current = current.next;
	            }
	        return false;
	        }
	               
	    public boolean isEmpty() {
	        return head == null;
	        }
	        
	    public boolean isFull() {
	        return false;
	        }
	        
	    public int size() {
	        return currentSize;
	        }
	        
	    public Iterator<E> iterator() {
	        return new ListIteratorHelper();
	        }
	}

	private interface ListADT<E> extends Iterable<E> {


	//  Adds the Object obj to the beginning of the list
	    public void addFirst(E obj);

	//  Adds the Object obj to the end of the list
	    public void addLast(E o);

	//  Removes the first Object in the list and returns it.
	//  Returns null if the list is empty.
	    public E removeFirst();

	//  Removes the last Object in the list and returns it.
	//  Returns null if the list is empty.
	    public E removeLast();

	//  Returns the first Object in the list, but does not remove it.
	//  Returns null if the list is empty.
	    public E peekFirst();

	//  Returns the last Object in the list, but does not remove it.
	//  Returns null if the list is empty.
	    public E peekLast();
	    
	//  Finds and returns the Object obj if it is in the list, otherwise
	//  returns null.  Does not modify the list in any way
	    public E find(E obj);

	//  Removes the first instance of thespecific Object obj from the list, if it exists.
	//  Returns true if the Object obj was found and removed, otherwise false
	    public boolean remove(E obj);

	//  The list is returned to an empty state.
	    public void makeEmpty();

	//  Returns true if the list contains the Object obj, otherwise false
	    public boolean contains(E obj);

	//  Returns true if the list is empty, otherwise false
	    public boolean isEmpty();

	//  Returns true if the list is full, otherwise false
	    public boolean isFull();

	//  Returns the number of Objects currently in the list.
	    public int size();

	//  Returns an Iterator of the values in the list, presented in
	//  the same order as the list.
	    public Iterator<E> iterator();

	}

}
