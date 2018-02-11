package com.qinlong.chapter8;
//Ö®×ÖÐÎ´òÓ¡¾ØÕó
public class PrintMatrixZigZag {

	public void printMatrixZigZag(int[][]matrix) {
		int tR=0;
		int tC=0;
		int dR=0;
		int dC=0;
		int endR=matrix.length-1;
		int endC=matrix[0].length-1;
		boolean fromUp=false;
		while (tR!=endR+1) {
			printLevel(matrix, tR, tC, dR, dC, fromUp);
			tR=tC==endC?tR+1:tR;
			tC=tC==endC?tC:tC+1;
			dR=dR==endR?dR:dR+1;
			dC=dR==endR?dC+1:dC;
			fromUp=!fromUp;
		}
		
	}
	
	public void printLevel(int[][]m,int tR,int tC,int dR,int dC,boolean f) {
		if (f) {
			while (tR!=dR+1) {
				System.out.print(m[tR++][tC--]+" ");
			}
		}else {
			while (dR!=tR-1) {
				System.out.print(m[dR--][dC++]+" ");
			}
		}
	}
}
