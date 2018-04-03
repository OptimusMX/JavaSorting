package com.inteall.sort;

public class BubbleSort {
	/**
	 * ��ͳ��ð������
	 * @param arr
	 * @return
	 */
	public static int[] bubbleSort(int [] arr){
		int count=0;
		int countx=0;
		if(arr==null){
			System.out.println("���벻��Ϊnull");
			throw new NullPointerException();
		}
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				countx++;
				if(arr[j]>arr[j+1]){
					count++;
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println("count:"+count);
		System.out.println("countx:"+countx);
		return arr;
	}
	/**
	 * �Ľ�ð������
	 * @param arr
	 * @return
	 */
	public static int[] newBubbleSort(int [] arr){
		int count=0;
		int countx=0;
		if(arr==null){
			System.out.println("���벻��Ϊnull");
			throw new NullPointerException();
		}
		int left=0;
		int right=arr.length-1;
		while(left<right){
			for(int i=left;i<right;i++){
				countx++;
				if(arr[i]>arr[i+1]){
					count++;
					int temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
			right--;
			for(int j=right;j>left;j--){
				countx++;
				if(arr[j]<arr[j-1]){
					count++;
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
			left++;
		}
		System.out.println("count:"+count);
		System.out.println("countx:"+countx);
		return arr;
	}

}
