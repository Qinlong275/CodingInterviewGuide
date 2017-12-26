package com.qinlong.chapter1;

import java.util.HashMap;
import java.util.Stack;

import com.sun.jmx.mbeanserver.NamedObject;

//构造数组的MaxTree

class Node{
	public int value;
	public Node left;
	public Node right;
	
	public Node(int date){
		this.value=date;
	}
}

public class MaxTree {
	public Node getMaxTree(int[] arr){
		Node[]nArr=new Node[arr.length];
		for (int i = 0; i < nArr.length; i++) {
			nArr[i]=new Node(arr[i]);
		}
		Stack<Node> stack=new Stack<>();
		HashMap<Node, Node> lBigMap=new HashMap<>();
		HashMap<Node, Node> rBigMap=new HashMap<>();
		
		for (int i = 0; i < nArr.length; i++) {
			Node node = nArr[i];
			while ((!stack.isEmpty())&&stack.peek().value<node.value) {
				popStackSetMap(stack, lBigMap);
			}
			stack.push(node);
		}
		while (!stack.isEmpty()) {
			popStackSetMap(stack, lBigMap);
		}
		
		for (int i = nArr.length-1; i!=-1; i--) {
			Node node = nArr[i];
			while ((!stack.isEmpty())&&stack.peek().value<node.value) {
				popStackSetMap(stack, rBigMap);
			}
			stack.push(node);
		}
		while (!stack.isEmpty()) {
			popStackSetMap(stack, rBigMap);
		}
		
		Node head=null;
		for (int i = 0; i < nArr.length; i++) {
			Node node=nArr[i];
			Node left=lBigMap.get(node);
			Node right=rBigMap.get(node);
			if (left==null&&right==null) {
				head=node;
			}else if(left==null){
				if (right.left==null) {
					right.left=node;
				}else {
					right.right=node;
				}
			}else if (right==null) {
				if (left.left==null) {
					left.left=node;
				}else {
					left.right=node;
				}
			}else {
				Node parent=left.value<right.value?left:right;
				if (parent.left==null) {
					parent.left=node;
				}else {
					parent.right=node;
				}
			}
		}
		return head;
	}
	
	public void popStackSetMap(Stack<Node> stack,HashMap<Node, Node> map) {
		Node popNode=stack.pop();
		if (stack.isEmpty()) {
			map.put(popNode, null);
		}else {
			map.put(popNode, stack.peek());
		}
	}
}
