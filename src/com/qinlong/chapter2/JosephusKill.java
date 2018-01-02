package com.qinlong.chapter2;
//环形单链表的约瑟夫问题
public class JosephusKill {

	public Node josephusKill1(Node head,int m) {
		if (head==null||m<1||head.next==head) {
			return head;
		}
		Node last=head;
		while (last.next!=head) {
			last=last.next;
		}
		int count=0;
		while (last!=head) {
			if (++count==m) {
				last.next=head.next;
				count=0;
			}else {
				last=last.next;
			}
			head=last.next;
		}
		return head;
	}
	
	public Node josephusKill2(Node head,int m) {
		if (head==null||head.next==head||m<1) {
			return head;
		}
		Node cur=head.next;
		int tmp=1;
		while (cur!=head) {
			tmp++;
			cur=cur.next;
		}
		tmp=getLive(tmp, m);
		while (--tmp!=0) {
			head=head.next;
		}
		head.next=head;
		return head;
	}
	
	public int getLive(int i,int m) {
		if (i==1) {
			return 1;
		}
		return (getLive(i-1, m)+m-1)%i+1;
	}
}
