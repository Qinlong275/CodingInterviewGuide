package com.qinlong.chapter5;
//给定一个字符串str,求其中全部数字所代表的数字之和
public class NumSum {

	public int numSum(String str) {
		if (str==null) {
			return 0;
		}
		char[] charArr=str.toCharArray();
		int res=0;
		int num=0;
		int cur=0;
		boolean posi=true;
		for (int i = 0; i < charArr.length; i++) {
			cur=charArr[i]-'0';
			if (cur<0||cur>9) {
				res+=num;
				num=0;
				if (charArr[i]=='-') {
					if (i-1>-1&&charArr[i-1]=='-') {
						posi=!posi;
					}else {
						posi=false;
					}
				}else {
					posi=true;
				}
			}else {
				num=num*10+(posi?cur:-cur);
			}
		}
		res+=num;
		return res;
	}
}
