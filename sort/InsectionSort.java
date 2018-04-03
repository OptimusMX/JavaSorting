package com.inteall.sort;

public class InsectionSort {
	/**
	 * �򵥲�������
	 * @param arr
	 * @param n
	 * @return
	 */
    public static int[] insertSort(int[] arr,int n){
        if(arr==null){
            System.out.println("��������鲻��Ϊnull");
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
     * ���ֲ�������
     * @param arr
     * @param n
     * @return
     */
    public static int[] insertSort2(int[]arr,int n){
        if(arr==null){
            System.out.println("��������鲻��Ϊnull");
            throw new NullPointerException();
        }
        int left,right,mid,temp;
        for(int i=1;i<n;i++){
            left=0;
            right=i-1;
            temp=arr[i];
            //ͨ���Ƚ��ҵ�Ҫ�����λ��
            while(left<=right){
                mid=(left+right)/2;
                if(arr[i]>arr[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            //λ���ҵ��ˣ���Ԫ�ز��뵽��λ��
            for(int j=i-1;j>=left;j--){
                arr[j+1]=arr[j];
            }
            arr[left]=temp;
        }
        return arr;
    }
	/**
	 * ϣ������
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int[] shellSort(int[] arr,int n){  
	    if(arr==null){  
	        System.out.println("�������鲻��Ϊnull");  
	        throw new NullPointerException();  
	    }  
	    int temp,j;  
	    //��������������ֳ�������  
	    for(int gap=n/2;gap>0;gap=gap/2){  
	        //���յ�ǰ�������������飬���ջ�����������˼������  
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
