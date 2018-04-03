package com.inteall.sort;

import java.util.Stack;

public class QuickSort {
	/**
	 * �����������д����
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] quickSort(int[] arr,int left,int right){
		if(arr==null){
			System.out.println("��������鲻��Ϊnull");
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
	 * �ǵݹ�ʵ�ֵĿ�������
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] quickSort3(int[] arr,int left,int right){
		if(arr==null){
			System.out.println("��������鲻��Ϊnull");
			throw new NullPointerException();
		}
		if(left<right){
			Stack<Integer> stack=new Stack<Integer>();
			//����ѡ�������pivot��ŦԪ����Ȼ����������飬һ��С����ŦԪ��һ����ڵ�����ŦԪ
			int pivot=partition(arr, left, right);
			//��������鰴��˳�����ջ
			if(left<pivot-1){
				stack.push(left);
				stack.push(pivot-1);
			}
			//���Ҳ����鰴��˳�����ջ
			if(right>pivot){
				stack.push(pivot);
				stack.push(right);
			}
			//ֻҪջ��Ϊ�գ�һֱѭ����ȥ��һֱȡ����������Ȼ���ٰѷֺ����ķŽ�ȥ��ֱ���������ٷ֣���һֱ����ȡ�����ջȡ�ա�����
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
	 * �����������д���ķ��鷽��
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
	 * ����������ֵ�ָ�����ҶԳ���С��10��������ò�������
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] quickSort1(int[] arr,int left,int right){
		if(arr==null){
			System.out.println("��������鲻��Ϊnull");
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
	 * ������ֵ�ָѡ��pivot
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
	 * ����λ�÷���
	 */
	private static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
