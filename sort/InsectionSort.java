package com.inteall.sort;

public class InsectionSort {
	/**
	 * 简单插入排序
	 * @param arr
	 * @param n
	 * @return
	 */
    public static int[] insertSort(int[] arr,int n){
        if(arr==null){
            System.out.println("输入的数组不能为null");
            throw new NullPointerException();
        }
        for (int i = 1; i < n; i++)         
        {
            int get = arr[i];                 
            int j = i - 1;                  
            while (j >= 0 && arr[j] > get)   
            {
                arr[j + 1] = arr[j];           
                j--;
            }
            arr[j + 1] = get; 
        }
        return arr;
    }
    /**
     * 二分插入排序
     * @param arr
     * @param n
     * @return
     */
    public static int[] insertSort2(int[]arr,int n){
        if(arr==null){
            System.out.println("输入的数组不能为null");
            throw new NullPointerException();
        }
        int left,right,mid,temp;
        for(int i=1;i<n;i++){
            left=0;
            right=i-1;
            temp=arr[i];
            //通过比较找到要插入的位置
            while(left<=right){
                mid=(left+right)/2;
                if(arr[i]>arr[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            //位置找到了，把元素插入到该位置
            for(int j=i-1;j>=left;j--){
                arr[j+1]=arr[j];
            }
            arr[left]=temp;
        }
        return arr;
    }
	/**
	 * 希尔排序
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int[] shellSort(int[] arr,int n){  
	    if(arr==null){  
	        System.out.println("输入数组不能为null");  
	        throw new NullPointerException();  
	    }  
	    int temp,j;  
	    //按照增量将数组分成若干组  
	    for(int gap=n/2;gap>0;gap=gap/2){  
	        //按照当前增量，遍历数组，按照基本插入排序思想排序  
	        for(int i=gap;i<n;i++){  
	            temp=arr[i];  
	            for(j=i;j-gap>=0&&(arr[j]<arr[j-gap]);j-=gap)  
	                arr[j]=arr[j-gap];  
	            arr[j]=temp;  
	        }  
	    }  
	    return arr;  
	}  
}
