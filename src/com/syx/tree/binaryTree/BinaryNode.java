package com.syx.tree.binaryTree;

public class BinaryNode<T> {
	private T data;// 结点的数据域
	private BinaryNode<T> left;// 左孩子
	private BinaryNode<T> right;// 右孩子

	public BinaryNode() {
		this(null);
	}

	public BinaryNode(T data) {
		this(data, null, null);
	}

	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return (left == null) && (right == null);
	}

	public int getNumberOfNodes() {
		int leftNumber = 0;
		int rightNumber = 0;
		if (left != null)
			leftNumber = left.getNumberOfNodes();
		if (right != null)
			rightNumber = right.getNumberOfNodes();
		return 1 + leftNumber + rightNumber;
	}

	public int getHeight() {
		return getHeight(this);
	}

	private int getHeight(BinaryNode<T> node) {
		int height = 0;
		if (node != null)
			height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		return height;
	}

	public int getLeafCount() {
		int lcount = 0;
		int rcount = 0;
		if (left != null)
			lcount = left.getLeafCount();
		if (right != null)
			rcount = right.getLeafCount();
		return isLeaf() ? (1 + lcount + rcount) : (lcount + rcount);
	}

	public BinaryNode<T> copy() {
		BinaryNode<T> newRoot = new BinaryNode<T>(data);
		if (left != null)
			newRoot.left = left.copy();
		if (right != null)
			newRoot.right = right.copy();
		return newRoot;
	}

}
