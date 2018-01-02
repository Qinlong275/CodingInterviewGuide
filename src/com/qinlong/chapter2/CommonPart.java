package com.qinlong.chapter2;
//打印两个有序链表公共部分
public class CommonPart {
	public void printCommonPart(Node head1,Node head2) {
		System.out.print("Common part: ");
		while (head1!=null&&head2!=null) {
			if (head1.value<head2.value) {
				head1=head1.next;
			}else if (head2.value>head1.value) {
				head2=head2.next;
			}else {
				System.out.print(head1.value);
			}
		}
		System.out.println();
	}
}
