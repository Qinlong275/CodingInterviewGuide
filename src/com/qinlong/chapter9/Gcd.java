package com.qinlong.chapter9;
//һ�д��������Լ��
public class Gcd {

	public int gcd(int m,int n) {
		return n==0?m:gcd(n, m%n);
	}
}
