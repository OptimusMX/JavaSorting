package com.inteall.sort;

public class HeapSort {
	/**
	 * �������������У�
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int[] heapSort(int[] arr,int n){
		if(arr==null){
			System.out.println("��������鲻��Ϊnull");
			throw new NullPointerException();
		}
		//�ؽ��󶥶�
		for(int i=n/2-1;i>=0;i--){
			adjustHeap(arr,i,n);
		}
		//ѭ��ִ�н����Ѷ������һ��Ԫ�أ��ٵ�����
		for(int j=n-1;j>=0;j--){
			swap(arr,j,0);
			adjustHeap(arr, 0, j);
		}
		return arr;
	}
	/**
	 * У���󶥶�
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void adjustHeap(int[] arr,int i,int j){
		int temp=arr[i];
		for(int k=2*i+1;k<j;k=2*k+1){
			//�жϵ�ǰ�ڵ�����ӽڵ�����ӽڵ��С����k��ָ��ָ��ϴ���ӽڵ�
			if(k+1<j&&arr[k]<arr[k+1]){
				k++;
			}
			//�ϴ��ӽڵ��뵱ǰ�ڵ�Ƚϣ�����ϴ��ӽڵ���ڵ�ǰ�ڵ㣬�򻥻�λ�ã�
			if(arr[k]>temp){
				swap(arr,k,i);
				//��Ϊ�ϴ��ӽڵ��뵱ǰ�ڵ㻥����λ�ã�����Ҫ���ǽϴ�ڵ������ӽڵ�
				//�Ƿ�����󶥶ѵ��������ͽ�iָ��ϴ��ӽڵ㴦���´�ѭ���������ϴ��ӽڵ㴦��ʼִ��
				i=k;
			}
		}
	}
	/**
	 * ����λ��
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
