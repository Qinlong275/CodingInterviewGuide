package com.qinlong.chapter8;

public class OrderPrint {
	
	public void spiralOrderPrint(int[][] matrix) {
		int tr=0;
		int tc=0;
		int dr=matrix.length-1;
		int dc=matrix[0].length-1;
		while (tr<=dr&&tc<=dc) {
			printEdge(matrix, tr++, tc++, dr--, dc--);
		}
	}
	
	public void printEdge(int[][] m,int tR,int tC,int dR,int dC) {
		if (tR==dR) {
			for (int i = tC; i <=dC; i++) {
				System.out.print(m[tR][i]+" ");
			}
		}else if (tC==dC) {
			for (int i = tR; i <dR; i++) {
				System.out.print(m[i][tC]+" ");
			}
		}else {
			int curR=tR;
			int curC=tC;
			while (curC!=dC) {
				System.out.print(m[tR][curC]+" ");
				curC++;
			}
			while (curR!=dR) {
				System.out.print(m[curR][dC]+" ");
			}
			while (curC!=tC) {
				System.out.print(m[dR][curC]+" ");
				curC--;
			}
			while (curR!=tR) {
				System.out.print(m[curR][tC]+" ");
				curR--;
			}
		}
	}

}
