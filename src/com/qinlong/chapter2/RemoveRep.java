package com.qinlong.chapter2;

import java.util.HashSet;

public class RemoveRep {
	
	public void removeRep1(Node head) {
		if (head==null) {
			return;
		}
		HashSet<Integer> set=new HashSet<>();
		set.add(head.value);
		Node pre=head;
		Node cur=head.next;
		while (cur!=null) {
			if (set.contains(cur)) {
				pre.next=cur.next;
			}else {
				set.add(cur.value);
				pre=cur;
			}
			cur=cur.next;
		}
	}
	
	public void removeRep2(Node head) {
		Node cur=head;
		Node pre=null;
		Node next=null;
		while (cur!=null) {
			pre=cur;
			next=cur.next;
			while (next!=null) {
				if (cur.value==next.value) {
					pre.next=next.next;
				}else {
					pre=next;
				}
				next=next.next;
			}
			cur=cur.next;
		}
	}

}
