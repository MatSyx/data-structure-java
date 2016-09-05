/**
 * 
 */
package com.syx.list.link;

/**
 * @author shiyongxiang
 *
 */
public class LinkList<T> {
	private class Node {
		private T data;
		private Node next;

		private Node() {
			// TODO Auto-generated constructor stub
		}

		private Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node header;

	public LinkList() {
		header = new Node(null);
	}

	public void insert(T element, int index) {
		Node node = header;
		int pos = 0;
		while (node != null && pos < index - 1) {
			node = node.next;
			pos++;
		}
		if (node == null || pos > index - 1)
			throw new IndexOutOfBoundsException("链表索引越界！");
		Node newNode = new Node(element);
		newNode.next = node.next;
		node.next = newNode;
	}

	public T delete(int index) {
		Node node = header;
		int pos = 0;
		while (node != null && pos < index - 1) {
			node = node.next;
			pos++;
		}
		if (node == null || pos > index - 1)
			throw new IndexOutOfBoundsException("链表索引越界！");
		Node tmpNode = node.next;
		node.next = tmpNode.next;
		T delValue = tmpNode.data;
		tmpNode = null;
		return delValue;
	}

	public T set(T element, int index) {
		Node node = header;
		int pos = 0;
		while (node != null && pos < index) {
			node = node.next;
			pos++;
		}
		if (node == null || pos > index)
			throw new IndexOutOfBoundsException("链表索引越界！");
		Node oldNode = node;
		node.data = element;
		return oldNode.data;
	}

	public T get(int index) {
		Node node = header;
		int pos = 0;
		while (node != null && pos < index) {
			node = node.next;
			pos++;
		}
		if (node == null || pos > index)
			throw new IndexOutOfBoundsException("链表索引越界！");
		return node.data;
	}

	public int indexOf(T element) {
		Node node = header.next;
		int index = 1;
		while (node != null) {
			if (!node.data.equals(element)) {
				node = node.next;
				index++;
			} else
				return index;
		}
		return -1; // node==null
	}

	public int length() {
		Node node = header.next;
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node node = header.next;
		if (node == null) {
			return "[]";
		} else {
			while (node != null) {
				sb.append(node.data.toString() + ", ");
				node = node.next;
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
}
