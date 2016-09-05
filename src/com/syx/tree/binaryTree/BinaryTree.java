package com.syx.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

	private BinaryNode<T> root;// 树根结点

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	}

	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<T>(rootData);
		if ((leftTree != null) && (!leftTree.isEmpty()))
			root.setLeft(leftTree.root);
		if ((rightTree != null) && (!rightTree.isEmpty())) {
			if (rightTree != leftTree)
				root.setRight(rightTree.root);
			else
				root.setRight(rightTree.root.copy());
		}
		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();
		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	}

	// 更改根结点的数据域
	protected void setRootData(T rootData) {
		root.setData(rootData);
	}

	public T getRootData() {
		T rootData = null;
		if (root != null)
			rootData = root.getData();// 调用节点的getData(),返回该节点的数据域
		return rootData;
	}

	// 更改根结点
	public BinaryNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}

	public int getHeight() {
		return root.getHeight();// 二叉树的高度即为以根结点为根的子树的高度
	}

	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	public int getLeafCount() {
		return root.getLeafCount();
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void clear() {
		root = null;
	}

	// 中序遍历二叉树
	public void inorderTraverse() {
		inorderTraverse(root);
	}

	private void inorderTraverse(BinaryNode<T> node) {
		if (node != null) {
			inorderTraverse(node.getLeft());
			System.out.println(node.getData());// 若使用迭代器，可以在测试程序中输出，而不是在这里使用输出语句
			inorderTraverse(node.getRight());
		}
	}

	public void preorderTraverse() {
		preorderTraverse(root);
	}

	private void preorderTraverse(BinaryNode<T> node) {
		if (node != null) {
			System.out.println(node.getData());
			preorderTraverse(node.getLeft());
			preorderTraverse(node.getRight());
		}
	}

	public void postorderTraverse() {
		postorderTraverse(root);
	}

	private void postorderTraverse(BinaryNode<T> node) {
		if (node != null) {
			postorderTraverse(node.getLeft());
			postorderTraverse(node.getRight());
			System.out.println(node.getData());
		}
	}
	
	public void levelTraverse() {
		levelTraverse(root);
	}
	
	private void levelTraverse(BinaryNode<T> root) {
		if(isEmpty())
			return;
		Queue<BinaryNode<T>> queue=new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryNode<T> node=queue.poll();
			System.out.println(node.getData());
			if(node.getLeft()!=null)
				queue.offer(node.getLeft());
			if(node.getRight()!=null)
				queue.offer(node.getRight());
		}
	}
}
