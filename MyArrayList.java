/**
 * Program 6
 * Creating Own ArrayList
 * CS108-3
 * 10-Apr-2018
 * @author Jillian Tan
*/
import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<E> extends MyAbstractList<E> implements MyList<E> {
	
	E[] array;
	protected static final int INITIAL_CAPACITY = 10;
	
	public MyArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(int INITIAL_CAPACITY) {
		super();
		array = (E[]) new Object[INITIAL_CAPACITY]; // let fail if bad parameter
		size = 0;
	}
	
	public String getIdentificationString() {
		String identification = "Program 6, Jillian Tan";
		return identification;
	}
	
	public int getCapacity() {
		return array.length;
	}
	
	/**
	 * Appends the specified E to the end of this list
	 * 
	 * @param data
	 *            element to insert
	 * @return boolean success
	 */
	@Override
	public boolean add(E data) {
		if (data != null) {
			if (this.size == this.array.length) {
				this.resize();
			}
			this.array[this.size++] = data;
		}
		return true;
	}
//			*verifyCapacity(size + 1);
//			array[size++] = data;
//			return true;
//		}
//		
//		private void verifyCapacity(int need) {
//			if (need >= array.length) //array is full
//				resize();
//		}
//		
//		private void resize() {
//			try {
//				E[] temp = (E[]) new E[array.length * 2];
//				//copy data
//				temp = Arrays.copyOf(array, temp.length);
//			}
//			catch (ArrayIndexOutOfBoundsException e) {
//				
//			}
//			this.array = temp;
//		}
//		
//	
	/**
	 * Appends the specified E to the list at the specified index
	 * 
	 * @param index
	 *            position to insert data
	 * @param data
	 *            element to insert
	 * @return boolean success
	 */
	@Override
	public boolean add(int index, E data) throws IndexOutOfBoundsException {
		for (index < 0 || index > size) {
			throws new IndexOutOfBoundsException();
		}
		add(data);
		for (int i = 2; i < index)
//		if (this.array[index] == null) {
//			this.array[index] = data;
//			size++;
//			return true;
//		}
//		else {
//			for (int i = 0; i < array.length; i++) {
//				array[i] = array[i + 1];
//			}
//			array[index] = data;
//			size++;
//			return true;
//		}
//		catch (ArrayIndexOutOfBoundsException e) {
//			throws new IndexOutOfBoundsException;
//		}
	}
	
	/**
	 * Let the garbage collector do the heavy lifting!
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
	}
	
	/**
	 * Returns true if this list contains the specified E
	 * 
	 * @param data
	 * @return boolean
	 */
	@Override
	public boolean contains(E data) {
		for (E element : this.array) {
			if (element == data) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Returns the E at the specified position in this list
	 * 
	 * @param index
	 * @return E
	 * @throws Exception
	 *             if index out of range
	 */
	@Override
	public E get(int index) throws Exception {
		if (checkRange(index)) {
			for (int i = 0; i < this.array.length; i++) {
				if (i == index)
					return this.array[i];
			}
		}
		return null;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified E in this
	 * list, or -1 if this list does not contain the E
	 * 
	 * @param data
	 *            element to search for
	 * @return int position of data if found, else -1
	 */
	@Override
	public int indexOf(E data) {
		if (data.equals(this.array[indexOf(null)])) {
			return indexOf(null);
		}
		else {
			return -1;
		}
	}
	
	/**
	 * Returns the E at the specified position in this list and deletes it
	 * from the list
	 * 
	 * @param index
	 *            element to remove
	 * @return E element removed if found, else null
	 * @throws Exception
	 *             if index out of range
	 */
	@Override
	public E remove(int index) throws Exception {
		E item = get(index);
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
		return item;
	}
	
	/**
	 * Trims the capacity of this instance to be the list's current size. An
	 * application can use this operation to minimize the storage of an
	 * instance.
	 */
	@Override
	public void trimToSize() {
		// ToDo
				// make array just this size
				// copy elements into it
				// list = newArray;
	}
	
	@Override
	public String toString() {

		String s = "[";
		if (!isEmpty()) {
			for (int i=0; i< size-1; i++)
				s += array[i] + ", ";
			s += array[size-1];
		}
		return s += "]";
	}

	/**
	 * Grow array
	 */
	private void resize() {
		try {
			this.array = this.doubleArraySizeAndCopy();
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
	}

	/**
	 * Double size and copy elements.  
	 * @return E[]
	 */
	@SuppressWarnings("unchecked") // uncomment for generic type
	private E[] doubleArraySizeAndCopy() {
		E[] temp = (E[]) new Object[this.array.length * 2];
		temp = Arrays.copyOf(array, temp.length);
		return temp;
	}

	private boolean checkRange(int index) throws Exception {
		if (index < 0)
			throw new IllegalArgumentException("Index cannot be negative");
		if (index >= this.size)
			throw new IndexOutOfBoundsException(
					"Cannot access " + index + " element");
		return true;
	}

	@Override
	public int lastIndexOf(E data) {
		// TODO Auto-generated method stub
		return 0;
	}	
	
}
