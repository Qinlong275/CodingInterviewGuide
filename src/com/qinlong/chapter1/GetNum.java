package com.qinlong.chapter1;
//最大值减去最小值小于或等于num的子数组数量
import java.util.LinkedList;

public class GetNum {

	public int getNum(int []arr,int num) {
		if (arr==null||arr.length==0) {
			return 0;
		}
		LinkedList<Integer> qmin=new LinkedList<>();
		LinkedList<Integer> qmax=new LinkedList<>();
		int i=0;
		int j=0;
		int res=0;
		while (i<arr.length) {
			while (j<arr.length) {
				while (!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[j]) {
					qmin.pollLast();
				}
				qmin.addLast(j);
				while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[j]) {
					qmax.pollLast();
				}
				qmax.addLast(j);
				if (arr[qmax.peekFirst()]-arr[qmin.peekFirst()]>num) {
					break;
				}
				j++;
			}
			if (qmin.peekFirst()==i) {
				qmin.pollFirst();
			}
			if (qmax.peekFirst()==i) {
				qmax.peekFirst();
			}
			res+=j-i;
			i++;
		}
		return res;
	}
}
