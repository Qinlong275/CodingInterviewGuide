package com.qinlong.chapter3;

public class PrintEdge {
	
	public void printEdge1(Node head) {
		if (head==null) {
			return;
		}
		int height=getHeight(head, 0);
		Node[][] edgeMap=new Node[height][2];
		setEdgeMap(head, 0, edgeMap);
		//打印左边界
		for (int i = 0; i < edgeMap.length; i++) {
			System.out.print(edgeMap[i][0].value+" ");
		}
		//打印既不是左边界也不是右边界的叶子节点
		printLeafNotInMap(head, 0, edgeMap);
		//打印右边界，但不是左边界的
		for (int i = edgeMap.length-1; i>-1; i--) {
			if (edgeMap[i][1]!=edgeMap[i][0]) {
				System.out.print(edgeMap[i][1].value+" ");
			}
		}
		System.out.println();
	}

	public int  getHeight(Node h,int l) {
		if (h==null) {
			return l;
		}
		return Math.max(getHeight(h.left, l+1), getHeight(h.right, l+1));
	}
	
	public void setEdgeMap(Node h,int l,Node[][] edgeMap) {
		if (h==null) {
			return;
		}
		edgeMap[l][0]=edgeMap[l][0]==null?h:edgeMap[l][0];
		edgeMap[l][1]=h;
		setEdgeMap(h.left, l+1, edgeMap);
		setEdgeMap(h.right, l+1, edgeMap);
	}
	
	public void printLeafNotInMap(Node h,int l,Node[][] m) {
		if (h==null) {
			return;
		}
		if (h.left==null&&h.right==null&&h!=m[l][0]&&h!=m[l][1]) {
			System.out.print(h.value+" ");
		}
		printLeafNotInMap(h.left, l+1, m);
		printLeafNotInMap(h.right, l+1, m);
	}
	
	
	public void printEdge2(Node head) {
		if (head==null) {
			return;
		}
		System.out.print(head.value+" ");
		if (head.left!=null&&head.right!=null) {
			printLeftEdge(head.left, true);
			printRightEdge(head.right, true);
		}else {
			printEdge2(head.left!=null?head.left:head.right);
		}
		System.out.println();
	}
	
	public void printLeftEdge(Node h,boolean print) {
		if (h==null) {
			return;
		}
		if (print||(h.left==null&&h.right==null)) {
			System.out.print(h.value+" ");
		}
		printLeftEdge(h.left, print);
		printLeftEdge(h.right, print&&h.left==null?true:false);
	}
	
	public void printRightEdge(Node h,boolean print) {
		if (h==null) {
			return;
		}
		printRightEdge(h.left, print&&h.right==null?true:false);
		printRightEdge(h.right, print);
		if (print||(h.left==null&&h.right==null)) {
			System.out.print(h.value+" ");
		}
	}
}
