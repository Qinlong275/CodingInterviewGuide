package com.qinlong.chapter3;

import java.util.Stack;

//分别用递归和非递归方式实现二叉树先序，中序，后序遍历
public class Order {

	public void preOrderRecur(Node head) {
		if (head==null) {
			return;
		}
		System.out.println(head.value+" ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	
	public void inOrderRecur(Node head) {
		if (head==null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.println(head.value+" ");
		inOrderRecur(head.right);
	}
	
	public void posOrderRecur(Node head) {
		if (head==null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.println(head.value+" ");
	}
	
	public void preOrderUnRecur(Node head) {
		System.out.println("pre-order: ");
		if (head!=null) {
			Stack<Node> stack=new Stack<>();
			stack.add(head);
			Node cur=null;
			while (!stack.isEmpty()) {
				cur=stack.pop();
				System.out.print(cur.value);
				if (cur.right!=null) {
					stack.push(cur.right);
				}
				if (cur.left!=null) {
					stack.push(cur.left);
				}
			}
			System.out.println();
		}
	}
	
	public void inOrderUnRecur(Node head) {
		System.out.println("in-order: ");
		if (head!=null) {
			Stack<Node> stack=new Stack<>();
			while (!stack.isEmpty()||head!=null) {
				if (head!=null) {
					stack.push(head);
					head=head.left;
				}else {
					head=stack.pop();
					System.out.println(head.value);
					head=head.right;
				}
			}
		}
		System.out.println();
	}
	
	public void posOrderUnRecur1(Node head) {
		System.out.println("pos-order: ");
		if (head!=null) {
			Stack<Node> s1=new Stack<>();
			Stack<Node> s2=new Stack<>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head=s1.pop();
				s2.push(head);
				if (head.left!=null) {
					s1.push(head.left);
				}
				if (head.right!=null) {
					s2.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value+" ");
			}
		}
		System.out.println();
	}
	
	public void posOrderUnRecur2(Node h) {
		System.err.println("pos-order: ");
		if (h!=null) {
			Stack<Node> stack=new Stack<>();
			stack.push(h);
			Node cur=null;
			while (!stack.isEmpty()) {
				cur=stack.peek();
				if (cur.left!=null&&h!=cur.left&&h!=cur.right) {
					stack.push(cur.left);
				}else if (cur.right!=null&&h!=cur.right) {
					stack.push(cur.right);
				}else {
					System.out.print(stack.pop().value+" ");
					h=cur;
				}
			}
		}
		System.out.println();
	}
}
