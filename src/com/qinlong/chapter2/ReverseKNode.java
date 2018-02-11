package com.qinlong.chapter2;

import java.util.Stack;

//���������ÿK���ڵ�֮������
public class ReverseKNode {
	
	public Node reverseKNode1(Node head,int k) {
		if (k<2) {
			return head;
		}
		Stack<Node> stack=new Stack<>();
		Node newHead=head;
		Node cur=head;
		Node pre=null;
		Node next=null;
		while (cur!=null) {
			next=cur.next;
			stack.push(cur);
			if (stack.size()==k) {
				pre=resign1(stack, pre, next);
				newHead=newHead==head?cur:newHead;
			}
			cur=next;
		}
		return newHead;
	}

	public Node resign1(Stack<Node> stack,Node left,Node right) {
		Node cur=stack.pop();
		if (left!=null) {
			left.next=cur;
		}
		Node next=null;
		while (!stack.isEmpty()) {
			cur.next=stack.pop();
			cur=cur.next;
		}
		cur.next=right;
		return cur;
	}
	
	public Node reverseKNode2(Node head,int k) {
		if (k<2) {
			return head;
		}
		Node cur=head;
		Node pre=null;
		Node start=null;
		Node next=null;
		int count=1;
		while (cur!=null) {
			next=cur.next;
			if (count==k) {
				start=pre==null?head:pre.next;
				head=pre==null?cur:head;
				resign2(pre, start, cur, next);
				pre=start;
				count=0;
			}
			count++;
			cur=next;
		}
		return head;
	}
	
	public void resign2(Node left,Node start,Node end,Node right) {
		Node pre=start;
		Node cur=start.next;
		Node next=null;
		while (cur!=null) {
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		if (left!=null) {
			left.next=end;
		}
		start.next=right;
	}
}
