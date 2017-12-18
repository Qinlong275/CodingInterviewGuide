package com.qinlong.chapter1;
//兩個棧实现一个队列

import java.util.Stack;

public class TwoStackQueue {

	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	
	public TwoStackQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
		super();
		this.stackPush = stackPush;
		this.stackPop = stackPop;
	}
	
	public void add(int puahInt) {
		stackPush.push(puahInt);
	}
	
	public int poll() {
		if (stackPop.empty()&&stackPush.empty()) {
			throw new RuntimeException("queue is empty");
		}else if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
		
	}
	
	public int peek() {
		if (stackPop.empty()&&stackPush.empty()) {
			throw new RuntimeException("queue is empty");
		}else if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		
		return stackPop.peek();
	}
}
