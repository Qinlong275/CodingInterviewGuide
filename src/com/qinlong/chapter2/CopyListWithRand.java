package com.qinlong.chapter2;

import java.util.HashMap;

//复制含有随机指针的链表
class NodeR {
	public int value;
	public NodeR next;
	public NodeR raNode;

	public NodeR(int data) {
		value = data;
	}

}

public class CopyListWithRand {
	public NodeR copyWithRand1(NodeR head) {
		HashMap<NodeR, NodeR> map = new HashMap<>();
		NodeR cur = head;
		while (cur != null) {
			map.put(cur, new NodeR(cur.value));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).raNode = map.get(cur.raNode);
			cur = cur.next;
		}
		return map.get(head);
	}
	
	public NodeR copyWithRand2(NodeR head) {
		if (head==null) {
			return null;
		}
		NodeR cur=head;
		NodeR next=null;
		//复制并连接每一个节点
		while (cur!=null) {
			next=cur.next;
			cur.next=new NodeR(cur.value);
			cur.next.next=next;
			cur=next;
		}
		cur=head;
		NodeR curCopy=null;
		//设置复制节点的rand指针
		while (cur!=null) {
			next=cur.next.next;
			curCopy=curCopy.next;
			curCopy.raNode=cur.raNode!=null?cur.raNode.next:null;
			cur=next;
		}
		NodeR res=cur.next;
		cur=head;
		//拆分两个链表
		while (cur!=null){
			next=cur.next.next;
			curCopy=cur.next;
			cur.next=next;
			curCopy.next=next!=null?next.next:null;
			cur=next;
		}
		return res;
	}

}
