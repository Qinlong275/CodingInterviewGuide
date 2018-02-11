package com.qinlong.chapter9;
//有关阶乘的两个问题
public class ZeroNum {
	
	public int name(int num) {
		if (num<0) {
			return 0;
		}
		int res=0;
		int cur=0;
		for (int i = 5; i < num+1; i=i+5) {
			cur=i;
			while (cur%5==0) {
				res++;
				cur/=5;
			}
		}
		return res;
	}

	public int rightOne1(int num) {
		if (num<1) {
			return -1;
		}
		int rea=0;
		while (num!=0) {
			num>>>=1;
			rea+=num;
		}
		return rea;
	}
}
