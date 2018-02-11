package com.qinlong.chapter8;
//找出无序数组中最小的K个数
public class GetMinKNumByHeap {

	public int[] GetMinKNumByHeap(int []arr,int k) {
		if (k<1||k>arr.length) {
			return arr;
		}
		int [] kHeap=new int[k];
		for (int i = 0; i < k; i++) {
			heapInsert(kHeap, arr[i], i);
		}
		for (int i = k; i < arr.length; i++) {
			if (arr[i]<kHeap[0]) {
				kHeap[0]=arr[i];
				heapify(kHeap, 0, k);
			}
		}
		return kHeap;
	}
	
	public void heapInsert(int[]arr,int value,int index) {
		arr[index]=value;
		while (index!=0) {
			int parent=(index-1)/2;
			if (arr[parent]<arr[index]) {
				swap(arr, index, parent);
				index=parent;
			}else {
				break;
			}
		}
	}
	
	public void heapify(int []arr,int index,int heapSize) {
		int left=index*2+1;
		int right=index*2+2;
		int lage=index;
		while (left<heapSize) {
			if (arr[left]>arr[index]) {
				lage=left;
			}
			if (arr[right]>arr[lage]&&right<heapSize) {
				lage=right;
			}
			if (lage!=index) {
				swap(arr, lage, index);
			}
			index=lage;
			left=index*2+1;
			right=index*2+2;
		}
	}
	
	public void swap(int[]arr,int a,int b) {
		int tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}
}
