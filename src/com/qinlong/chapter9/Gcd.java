package com.qinlong.chapter9;
//一行代码求最大公约数
public class Gcd {

	public int gcd(int m,int n) {
		return n==0?m:gcd(n, m%n);
	}
}
