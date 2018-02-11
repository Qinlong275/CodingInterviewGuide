package com.qinlong.chapter7;
//不用任何比较找出两个数中较大数
public class GetMax {
	
	//
	public int flip(int n) {
		return n^1;
	}
	
	public int sign(int n) {
		return flip((n>>31)&1);
	}
	
	public int getMax1(int a,int b) {
		int c=a-b;
		int scA=sign(c);
		int scB=flip(scA);
		return scA*a+scB*b;
	}
	
	//
	public int getMax2(int a,int b) {
		int c=a-b;
		int sa=sign(a);
		int sb=sign(b);
		int sc=sign(c);
		int difsab=sa^sb;
		int samesab=flip(difsab);
		int returnA=difsab*sa+samesab*sc;
		int returnB=flip(returnA);
		return returnA*a+returnB*b;
	}

}
