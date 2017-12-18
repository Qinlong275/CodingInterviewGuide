package com.qinlong.chapter1;
//设计一个有getMin功能的栈

import java.util.Stack;

public class MysStack2 {
	
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MysStack2(Stack<Integer> stackData, Stack<Integer> stackMin) {
		super();
		this.stackData = stackData;
		this.stackMin = stackMin;
	}
	
	public void push(int newNum) {
		if (stackMin.isEmpty()) {
			stackMin.push(newNum);
		}else if(newNum<getMin()){
			stackMin.push(newNum);
		}else {
			int newMin=stackMin.peek();
			stackMin.push(newMin);
		}
		stackData.push(newNum);
	}
	
	public int pop() {
		if (stackData.isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		
		stackMin.pop();
		return stackData.pop();
	}
	
	public int getMin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return this.stackMin.peek();
	}
}
