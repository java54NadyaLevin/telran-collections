package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 6;
	private int size;
	private T[] array;

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	private class ArrayListIterator implements Iterator<T> {
		int i = 0;

		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return array[i++];
		}
	}

	@Override
	/**
	 * adds object at end of array, that is, at index == size
	 */
	public boolean add(T obj) {
		checksize();
		array[size++] = obj;
		return true;
	}

	private void checksize() {
		if (size == array.length) {
			allocate();
		}
	}

	private void allocate() {
		array = Arrays.copyOf(array, array.length * 2);

	}

	@Override
	public boolean remove(T pattern) {
		int index = indexOf(pattern);
		boolean res = false;
		if (index > -1) {
			res = true;
			remove(index);
		}
		return res;
	}

	@Override
	public boolean contains(T pattern) {

		return indexOf(pattern) > -1;
	}

	@Override
	public int size() {

		return size;
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}

	@Override
	public T get(int index) {
		checkIndex(index);
		return array[index];
	}

	@Override
	public void add(int index, T obj) {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
			checksize();
		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = obj;
		size++;
	}

	@Override
	public T remove(int index) {
		checkIndex(index);
		T ref = array[index];
		for (int i = index; i < size; i++) {
			array[i] = array[i + 1];
		}
		array[size - 1] = null;
		size--;

		return ref;
	}

	@Override
	public int indexOf(T pattern) {
		int index = 0;
		while (index < size && !array[index].equals(pattern)) {
			index++;
		}
		return index == size ? -1 : index;

	}

	@Override
	public int lastIndexOf(T pattern) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (array[i].equals(pattern)) {
				index = i;
			}
		}
		return index;
	}

}
