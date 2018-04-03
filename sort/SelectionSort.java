package com.inteall.sort;

public class SelectionSort {
	/**
	 * 选择排序
	 * @param arr
	 * @return
	 */
	public static int[] selectionSort(int[] arr,int n){
		if(arr==null){
			System.out.println("数组不能为null");
			throw new NullPointerException();
		}
		for(int i=0;i<n-1;i++){
			int min=i;
			for(int j=i+1;j<n;j++){
				if(arr[min]>arr[j]){
					min=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
		
		return arr;
	}
	/**
	 * 改进后的选择排序，二元选择排序
	 * @param arr
	 * @return
	 */
	public static int[] newSelectionSort(int[] arr,int n){
		if(arr==null){
			System.out.println("数组不能为null");
			throw new NullPointerException();
		}
		int min,max,temp,i,j;
		for(i=0;i<n/2;i++){
			min=i;max=i;
			for(j=i+1;j<n-i;j++){
				if(arr[max]<arr[j]){
					max=j;
					continue;
				}
				if(arr[min]>arr[j]){
					min=j;
				}
			}
			temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
			
		     if(max==i) 
		        {  
		    	 	temp=arr[n-i-1];
					arr[n-i-1]=arr[min];
					arr[min]=temp; 
		        }  
		        else
		        {  
		        	temp=arr[n-i-1];
					arr[n-i-1]=arr[max];
					arr[max]=temp;
		        } 
		}
		return arr;
	}
}
