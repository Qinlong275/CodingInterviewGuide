package com.qinlong.chapter2;

import java.util.Stack;

public class RemoveValue {

	public Node removeValue(Node head,int num) {
		Stack<Node> stack=new Stack<>();
		while (head!=null) {
			if (head.value!=num) {
				stack.push(head);
			}
			head=head.next;
		}
		while (!stack.isEmpty()) {
			stack.peek().next=head;
			head=stack.pop();
		}
		return head;
	}
	
	public Node removeValue2(Node head,int num) {
		while (head!=null) {
			if (head.value!=num) {
				break;
			}
			head=head.next;
		}
		Node pre=head;
		Node cur=head;
		while (cur!=null) {
			if (cur.value==num) {
				pre.next=cur.next;
			}else {
				pre=cur;
			}
			cur=cur.next;
		}
		return head;
	}
}
