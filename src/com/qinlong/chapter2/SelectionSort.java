package com.qinlong.chapter2;
//单链表的选择排序
public class SelectionSort {

	public Node selectionSort(Node head) {
		Node tail=null;
		Node cur=head;
		Node smallpre=null;
		Node small=null;
		while (cur!=null) {
			small=cur;
			smallpre=getSmallestPrenode(cur);
			if (smallpre!=null) {
				small=smallpre.next;
				smallpre.next=small.next;
			}
			cur=cur==small?cur.next:cur;
			if (tail==null) {
				head=small;
			}else {
				tail.next=small;
			}
			tail=small;
		}
		return head;
		
	}
	
	public Node getSmallestPrenode(Node head) {
		Node smallPre=null;
		Node small=head;
		Node pre=head;
		Node cur=head.next;
		while (cur!=null) {
			if (cur.value<small.value) {
				smallPre=pre;
				small=cur;
			}
			pre=cur;
			cur=cur.next;
		}
		return smallPre;
	}
}
