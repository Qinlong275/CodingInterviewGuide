package com.qinlong.chapter1;

import java.util.Stack;

//求最大子矩阵的大小
public class MaxRec {
	
	public int maxRecSize(int [][]map) {
		if (map==null||map.length==0||map[0].length==0) {
			return 0;
		}
		int maxArea=0;
		int []hight=new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < hight.length; j++) {
				hight[j]=map[i][j]==0?0:hight[j]+1;
			}
			maxArea=Math.max(maxRecFromBottom(hight), maxArea);
		}
		return maxArea;
	}
	
	public int maxRecFromBottom(int[] height) {
		if (height==null||height.length==0) {
			return 0;
		}
		int maxArea=0;
		Stack<Integer> stack=new Stack<>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty()&&height[i]<=height[stack.peek()]) {
				int j=stack.pop();
				int k=stack.isEmpty()?-1:stack.peek();
				int curArea=(i-k-1)*height[j];
				maxArea=Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j=stack.pop();
			int k=stack.isEmpty()?-1:stack.peek();
			int curArea=(height.length-k-1)*height[j];
			maxArea=Math.max(maxArea, curArea);
		}
		return maxArea;
	}
}
