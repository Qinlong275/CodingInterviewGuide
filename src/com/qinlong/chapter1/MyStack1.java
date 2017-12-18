package com.qinlong.chapter1;
//设计一个有getMin功能的栈

import java.util.Stack;

public class MyStack1 {

	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public MyStack1(Stack<Integer> stackData, Stack<Integer> stackMin) {
		super();
		this.stackData = stackData;
		this.stackMin = stackMin;
	}

	public void push(int newSum){
		if (this.stackMin.isEmpty()) {
			stackMin.push(newSum);
		}else if (newSum<=this.getMin()) {
			stackMin.push(newSum);
		}
		stackData.push(newSum);
		
	}
	
	public int pop() {
		
		if (stackData.isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		int value=stackData.pop();
		if (value==getMin()) {
			stackMin.pop();
		}
		return value;
	}
	
	public int getMin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return this.stackMin.peek();
	}
}
