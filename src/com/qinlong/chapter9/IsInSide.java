package com.qinlong.chapter9;
//判断一个点是否在矩形内部
public class IsInSide {

	public boolean isInSide(double x1,double y1,double x4,double y4,double x,double y) {
		if (x<=x1) {
			return false;
		}
		if (x>=x4) {
			return false;
		}
		if (y>=x1) {
			return false;
		}
		if (y<=y4) {
			return false;
		}
		return false;
	}
	
	public boolean isInSide(double x1,double y1,double x2,double y2,
			double x3,double y3,double x4,double y4,double x,double y) {
		if (y1==y2) {
			return isInSide(x1, y1, x4, y4, x, y);
		}
		double l=Math.abs(y4-y3);
		double k=Math.abs(x4-x3);
		double s=Math.sqrt(l*l+k*k);
		double sin=l/s;
		double cos=k/s;
		double x1R=cos*x1+sin*y1;
		double y1R=-x1*sin+y1*cos;
		double x4R=cos*x4+sin*y4;
		double y4R=-x4*sin+y4*cos;
		double xR=cos*x+sin*y;
		double yR=-x*sin+y*cos;
		return isInSide(x1R, y1R, x4R, y4R, xR, yR);
		
	}
}
