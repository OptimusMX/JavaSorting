package com.inteall.sort;

import java.util.PriorityQueue;

public class MainTest {
	
	public static void main(String[] args){
		int[] intArr={5,4,1,54,64,5,4,2,123,12,4,5,4,21,21,5,3333};
//		BubbleSort.bubbleSort(intArr);
//		SelectionSort.newSelectionSort(intArr,intArr.length);
//		QuickSort.quickSort3(intArr, 0, intArr.length-1);
//		HeapSort.heapSort(intArr,intArr.length);
		PriorityQueue<Integer> pQueue=new PriorityQueue<Integer>();
		int count=0;
		while(intArr.length!=count){
			pQueue.add(intArr[count]);
			count++;
		}
		while(!pQueue.isEmpty()){
			System.out.println(pQueue.remove());
		}
//		for (int i : intArr) {
//			System.out.println(i);
//		}
	}
}
