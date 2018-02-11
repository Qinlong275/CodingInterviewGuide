package com.qinlong.chapter3;

public class PrintTree {

	public void printTree(Node head) {
		System.out.println("Binary tree");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}
	
	public void printInOrder(Node head,int height,String to,int len) {
		if (head==null) {
			return;
		}
		printInOrder(head.right, height+1, "v", len);
		String val=to+head.value+to;
		int lenm=val.length();
		int lenf=(len-lenm)/2;
		int lenr=len-lenm-lenf;
		val=getSpace(lenf)+val+getSpace(lenr);
		System.out.println(getSpace(height*len)+val);
		printInOrder(head.left, height+1, "^", len);
		
		
	}
	
	public String getSpace(int num) {
		String space=" ";
		StringBuffer buffer=new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buffer.append(space);
		}
		return buffer.toString();
	}
}
