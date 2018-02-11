package com.qinlong.chapter9;
//从5随机到7随机极其扩展
public class RandomTo {
	
	//
	public int randTo5() {
		return (int)(Math.random()*5)+1;
	}
	
	public int randTo7() {
		int num=0;
		do {
			num=(randTo5()-1)*5+(randTo5()-1);
		} while (num>20);
		return num%7+1;
	}
	
	//
	public int rand01p() {
		double p=0.83;
		return Math.random()<p?0:1;
	}
	
	public int rand01() {
		int num;
		do {
			num=rand01p();
		} while (num==rand01p());
		return num;
	}
	
	public int rand03() {
		return rand01()*2+rand01();
	}
	
	public int rangTo6() {
		int num;
		do {
			num=rand03()*4+rand03();
		} while (num>11);
		return num%6+1;
	}
	
	//
	

}
