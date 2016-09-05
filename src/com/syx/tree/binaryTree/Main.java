package com.syx.tree.binaryTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<String> f = new BinaryTree<String>("F");
		BinaryTree<String> g = new BinaryTree<String>("G");
		BinaryTree<String> e = new BinaryTree<String>("E");
		BinaryTree<String> d = new BinaryTree<String>("D", f, g);
		BinaryTree<String> c = new BinaryTree<String>("C", d, e);
		BinaryTree<String> b = new BinaryTree<String>("B", null, c);
		BinaryTree<String> root = new BinaryTree<String>("A", b, null);

		System.out.println("先序遍历：");
		root.preorderTraverse();
		System.out.println("中序遍历：");
		root.inorderTraverse();
		System.out.println("后序遍历：");
		root.postorderTraverse();
		System.out.println("层次遍历：");
		root.levelTraverse();

		System.out.println("rootData " + root.getRootData());
		System.out.println("hight " + root.getHeight());
		System.out.println("node number " + root.getNumberOfNodes());
		System.out.println("leaf number " + root.getLeafCount());
	}

}
