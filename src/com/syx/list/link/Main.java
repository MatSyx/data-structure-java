/**
 * 
 */
package com.syx.list.link;

/**
 * @author shiyongxiang
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList<String> ll=new LinkList<>();
		System.out.println("length after init "+ll.length());
		ll.insert("aaa", 1);
		System.out.println("length after insert aaa "+ll.length());
		System.out.println(ll.toString());
		ll.insert("bbbb", 2);
		System.out.println("length after insert bbbb "+ll.length());
		System.out.println(ll.toString());
		ll.insert("before aaa", 1);
		System.out.println("length after insert "+ll.length());
		System.out.println(ll.toString());
		ll.insert("ccc", 4);
		System.out.println("length "+ll.length());
		System.out.println(ll.toString());
		ll.delete(3);
		System.out.println("length af del "+ll.length());
		System.out.println(ll.toString());
		System.out.println("index of "+ll.indexOf("a"));
		ll.set("aaaset", 2);
		System.out.println("length "+ll.length());
		System.out.println(ll.toString());
		System.out.println("get 3 is"+ll.get(3));
	}

}
