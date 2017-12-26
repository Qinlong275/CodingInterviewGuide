package com.qinlong.chapter1;

import java.util.Stack;

public class StackSort {
	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help=new Stack<>();
		while (!stack.isEmpty()) {
			int cu=stack.pop();
			while (!help.isEmpty()&&cu>help.peek()) {
				stack.push(help.pop());
			}
			help.push(cu);
		}
		
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}
}
