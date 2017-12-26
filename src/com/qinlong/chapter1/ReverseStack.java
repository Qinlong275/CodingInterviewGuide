package com.qinlong.chapter1;
//仅用递归函数和栈操作逆序一个栈
import java.util.Stack;

public class ReverseStack {

	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result=stack.pop();
		if (stack.empty()) {
			return result;
		}else {
			int last=getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	
	public static void reverse(Stack<Integer> stack) {
		if (stack.empty()) {
			return;
		}
		int i=getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}
}
