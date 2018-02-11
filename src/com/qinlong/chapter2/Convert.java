package com.qinlong.chapter2;
//将搜索二叉树转换成双向链表
import com.qinlong.chapter3.Node;
import java.util.LinkedList;
import java.util.Queue;

public class Convert {
	
	public Node name(Node head) {
		Queue<Node> queue=new LinkedList<>();
		inOrderToQueue(head, queue);
		if (queue.isEmpty()) {
			return head;
		}
		head=queue.poll();
		Node pre=head;
		pre.left=null;
		Node cur=null;
		while (!queue.isEmpty()) {
			cur=queue.poll();
			pre.right=cur;
			cur.left=pre;
			pre=cur;
		}
		pre.right=null;
		return head;
	}
	
	public void inOrderToQueue(Node head,Queue<Node> queue) {
		if (head==null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}

}
