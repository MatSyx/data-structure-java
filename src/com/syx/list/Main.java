/**
 * 
 */
package com.syx.list;

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
		SequenceList<String> sl=new SequenceList<>();
		System.out.println("length="+sl.length());
		sl.add("aa");
		sl.add("bb");
		System.out.println("length="+sl.length());
		sl.add("dada");
		System.out.println(sl.toString());
		sl.add("uuu");
		sl.insert("ccc", 2);
		System.out.println(sl.toString());
		System.out.println("delete "+sl.delete(4));
		System.out.println(sl.toString());
		System.out.println("remove "+sl.remove());
		System.out.println("get "+sl.get(1));
		System.out.println(sl.toString());
		System.out.println("bb indexof "+sl.indexOf("bb"));
		System.out.println("set 1 "+sl.set("set", 1));
		System.out.println(sl.toString());
		sl.clear();
		System.out.println(sl.toString());
	}

}
