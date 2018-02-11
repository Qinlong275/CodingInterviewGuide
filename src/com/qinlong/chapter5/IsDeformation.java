package com.qinlong.chapter5;
//�ж������ַ����Ƿ�Ϊ���δ�
public class IsDeformation {

	public boolean isDeformation(String str1,String str2) {
		if (str1==null||str2==null||str1.length()!=str2.length()) {
			return false;
		}
		char[] char1=str1.toCharArray();
		char[] char2=str2.toCharArray();
		int[] map=new int[256];
		for (int i = 0; i < char1.length; i++) {
			map[char1[i]]++;
		}
		for (int i = 0; i < char2.length; i++) {
			if (map[char2[i]]--==0) {
				return false;
			}
		}
		return true;
	}
}
