package com.qinlong.chapter1;

import java.util.Stack;

//用栈来求解汉诺塔问题
public class HanoiProblem2 {

	public enum Action{
		No,LToM,MToL,MToR,RToM
	}
	
	public int hanoiProblem2(int num,String left,String mid,String right) {
		Stack<Integer> lStack=new Stack<>();
		Stack<Integer> mStack=new Stack<>();
		Stack<Integer> rStack=new Stack<>();
		lStack.push(Integer.MAX_VALUE);
		mStack.push(Integer.MAX_VALUE);
		rStack.push(Integer.MAX_VALUE);
		for (int i = num; i >0; i--) {
			lStack.push(i);
		}
		Action[]record={Action.No};
		int step=0;
		while (rStack.size()!=num+1) {
			step+=sStackTotStack(record, Action.MToL, Action.LToM, lStack, mStack, left, mid);
			step+=sStackTotStack(record, Action.LToM, Action.MToL, mStack, lStack, mid, left);
			step+=sStackTotStack(record, Action.MToR, Action.RToM, rStack, mStack, right,mid);
			step+=sStackTotStack(record, Action.RToM, Action.MToR, mStack, rStack, mid, right);
		}
		
		return step;
	}
	
	public static int sStackTotStack(Action[] record,Action preNoAct,
			Action nowAct,Stack<Integer> fStack,Stack<Integer> tStack,String from,String to){
		if (record[0]!=preNoAct&&fStack.peek()<tStack.peek()) {
			tStack.push(fStack.pop());
			System.out.println("Move "+tStack.peek()+" from "+from+" to "+to);
			record[0]=nowAct;
			return 1;
		}
		return 0;
	}
}
