package com.inteall.sort;

public class HeapSort {
	/**
	 * 堆排序（升序排列）
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int[] heapSort(int[] arr,int n){
		if(arr==null){
			System.out.println("输入的数组不能为null");
			throw new NullPointerException();
		}
		//重建大顶堆
		for(int i=n/2-1;i>=0;i--){
			adjustHeap(arr,i,n);
		}
		//循环执行交换堆顶与最后一个元素，再调整堆
		for(int j=n-1;j>=0;j--){
			swap(arr,j,0);
			adjustHeap(arr, 0, j);
		}
		return arr;
	}
	/**
	 * 校正大顶堆
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void adjustHeap(int[] arr,int i,int j){
		int temp=arr[i];
		for(int k=2*i+1;k<j;k=2*k+1){
			//判断当前节点的左子节点和右子节点大小，让k的指针指向较大的子节点
			if(k+1<j&&arr[k]<arr[k+1]){
				k++;
			}
			//较大子节点与当前节点比较，如果较大子节点大于当前节点，则互换位置，
			if(arr[k]>temp){
				swap(arr,k,i);
				//因为较大子节点与当前节点互换了位置，就需要考虑较大节点与其子节点
				//是否还满足大顶堆的条件，就将i指向较大子节点处，下次循环会从这个较大子节点处开始执行
				i=k;
			}
		}
	}
	/**
	 * 交换位置
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
