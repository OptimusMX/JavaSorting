package com.inteall.sort;

import java.util.Stack;

public class QuickSort {
	/**
	 * 快速排序基本写法，
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] quickSort(int[] arr,int left,int right){
		if(arr==null){
			System.out.println("输入的数组不能为null");
			throw new NullPointerException();
		}
		if(left>=right){
			return arr;
		}
		int partIndex=partition(arr, left, right);
		quickSort(arr, left, partIndex-1);
		quickSort(arr, partIndex+1, right);
		return arr;
	}
	/**
	 * 非递归实现的快速排序
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] quickSort3(int[] arr,int left,int right){
		if(arr==null){
			System.out.println("输入的数组不能为null");
			throw new NullPointerException();
		}
		if(left<right){
			Stack<Integer> stack=new Stack<Integer>();
			//首先选择基数（pivot枢纽元），然后将数组分两组，一组小于枢纽元，一组大于等于枢纽元
			int pivot=partition(arr, left, right);
			//将左侧数组按照顺序放入栈
			if(left<pivot-1){
				stack.push(left);
				stack.push(pivot-1);
			}
			//将右侧数组按照顺序放入栈
			if(right>pivot){
				stack.push(pivot);
				stack.push(right);
			}
			//只要栈不为空，一直循环下去，一直取出来分区，然后再把分好区的放进去，直到区不能再分，就一直往外取，最后将栈取空。结束
			while(!stack.empty()){
				int rightTemp=stack.pop();
				int leftTemp=stack.pop();
				int pivotTemp=partition(arr,leftTemp,rightTemp);
				if(leftTemp<pivotTemp-1){
					stack.push(leftTemp);
					stack.push(pivotTemp-1);
				}
				if(pivotTemp+1<rightTemp){
					stack.push(pivotTemp+1);
					stack.push(rightTemp);
				}
			}
		}
		
		return arr;
	}
	/**
	 * 快速排序基本写法的分组方法
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] arr,int left,int right){
		int pivot=arr[right];
		int tail=left-1;
		for(int i=left;i<right;i++){
			if(arr[i]<pivot){
				swap(arr,++tail,i);
			}
		}
		swap(arr,right,tail+1);
		return tail+1;
	}
	/**
	 * 采用三数中值分割法，并且对长度小于10的数组采用插入排序，
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] quickSort1(int[] arr,int left,int right){
		if(arr==null){
			System.out.println("输入的数组不能为null");
			throw new NullPointerException();
		}
		
		if(left+10<right){
			int pivot=pivotFactory(arr, left, right);
			int i=left;
			int j=right;
			for(;;){
				while(arr[++i]<pivot){}
				while(arr[--j]>pivot){}
				if(i<j){
					swap(arr,i,j);
				}else{
					break;
				}
			}
			swap(arr,right-1,i);
			quickSort(arr, left, i-1);
			quickSort(arr, i+1, right);
			
		}else{
			InsectionSort.insertSort2(arr, arr.length);
		}
		
		return arr;
	}
	/**
	 * 三数中值分割法选择pivot
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int pivotFactory(int[] arr,int left,int right){
		int center=(left+right)/2;
		if(arr[left]>arr[center])
			swap(arr,left,center);
		if(arr[center]>arr[right])
			swap(arr,center,right);
		if(arr[center]<arr[left])
			swap(arr,center,left);
		swap(arr,center,right-1);
		return arr[right-1];
	}
	
	/*
	 * 调换位置方法
	 */
	private static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
