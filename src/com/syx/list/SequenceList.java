/**
 * 
 */
package com.syx.list;

import java.util.Arrays;

/**
 * @author shiyongxiang
 *
 */
public class SequenceList<T> {
	private final int DEFAULT_SIZE = 16;

	private Object[] elementData;
	private int capactiy;
	private int size;

	public SequenceList() {
		// TODO Auto-generated constructor stub
		capactiy = DEFAULT_SIZE;
		elementData = new Object[capactiy];
	}

	public SequenceList(int initSize) {
		capactiy = 1;
		while (capactiy < initSize)
			capactiy <<= 1;
		elementData = new Object[capactiy];
	}

	public int length() {
		return size;
	}

	public T get(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("顺序表索引越界！");
		return (T) elementData[index];
	}

	public int indexOf(T element) {
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(element))
				return i;
		}
		return -1;
	}

	public void insert(T element, int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("顺序表索引越界！");
		ensureCapacity(size + 1);
		for (int i = size; i > index; i--) {
			elementData[i] = elementData[i - 1];
		}
		elementData[index] = element;
		size++;
	}

	public void add(T element) {
		insert(element, size);
	}

	public T delete(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("顺序表索引越界！");
		T delValue = (T) elementData[index];
		int numToMove = size - index - 1;
		if (numToMove > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numToMove);
		}
		elementData[--size] = null;
		return delValue;
	}

	public T remove() {
		return delete(size - 1);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		Arrays.fill(elementData, null);
		size = 0;
	}

	public void ensureCapacity(int minCapacity) {
		if (minCapacity > capactiy) {
			while (capactiy < minCapacity)
				capactiy <<= 1;
			elementData = Arrays.copyOf(elementData, capactiy);
		}
	}

	@Override
	public String toString() {
		if (size == 0)
			return "[]";
		else {
			StringBuilder sb = new StringBuilder("[");
			for (int i = 0; i < size; i++)
				sb.append(elementData[i].toString() + ", ");
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
}
