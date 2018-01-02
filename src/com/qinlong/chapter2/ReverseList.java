package com.qinlong.chapter2;
//��ת���������˫������
public class ReverseList {

	public Node reverseList(Node head) {
		Node pre=null;
		Node next=null;
		while (head!=null) {
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		return pre;
	}
	
	public DoubleNode reverstList(DoubleNode head) {
		DoubleNode pre=null;
		DoubleNode next=null;
		while (head!=null) {
			next=head.next;
			head.next=pre;
			head.last=next;
			pre=head;
			head=next;
		}
		return pre;
	}
}
