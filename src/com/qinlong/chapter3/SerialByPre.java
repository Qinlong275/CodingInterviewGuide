package com.qinlong.chapter3;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的序列化和反序列化
public class SerialByPre {

	public String serialByPre(Node head) {
		if (head==null) {
			return "#!";
		}
		String res=head.value+"!";
		res+=serialByPre(head.left);
		res+=serialByPre(head.right);
		return res;
	}
	
	public Node reconBypreString(String preStr) {
		String[] val=preStr.split("!");
		Queue<String> queue=new LinkedList<>();
		for (int i = 0; i < val.length; i++) {
			queue.offer(val[i]);
		}
		return reconPreOrder(queue);
	}
	
	public Node reconPreOrder(Queue<String> queue) {
		String vue=queue.poll();
		if (vue.equals("#")) {
			return null;
		}
		Node head=new Node(Integer.valueOf(vue));
		head.left=reconPreOrder(queue);
		head.right=reconPreOrder(queue);
		return head;
	}
}
