package com.sky.ds.sorting;

import java.util.Arrays;

/**
 * Best case:
 * Pivot Element  = Median(Middle element of the list where elements to the left are smaller 
 * 		and element in the right are greater.
 * Time complexity = O(n log n) order of n log n
 * But for this median(element at the middle must be sorted) is not guaranteed. So achieving the
 * best case in QuickSort is not possible. It may randomly happen, if your median is sorted then it is the best 
 * case for quick sort.
 * 
 * Worst case:
 * If the quick sort is already sorted
 * Time complexity = n(n+1)/2 => O(n*n)
 * You can convert worst case into best case by selecting the pivot element as median. Since median is in sorted order.
 * You can also overcome from worst case by randomly selecting any element as pivot element. 
 * 
 * Average case:
 * Pivot Element = 1st or last element of the array.
 * Time complexity : O( n log n)
 * 
 * @author sandeepkumar
 *
 */
public class QuikSort {
	
	/**
	 * Only method which can be invoked to perform quick sort on the integer array
	 * @param arr
	 */
	public void sort(int[] arr){
		int low = 0;
		int high = arr.length-1;
		quickSort(arr, low, high);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * sort() method call quicksort to perform sorting by passing array, 0 and maximum no of elements in the array
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	private void quickSort(int[] arr, int low, int high){
		//if size is greater than zero 
		if(low<high){
			int median  = partition(arr, low, high); 
			quickSort(arr, 0, median);
			quickSort(arr, median+1, high);
		}
		
	}
	
	/**
	 * Divide and conquer the array in the ascending order
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private int partition(int arr[],int low,int high){
		//Makes array[0] as pivot element
		int pivot = arr[low];
		
		// i holds elements which are lower than pivot 
		int i=low+1;
		// j holds elements which are greater than pivot
		int j = high;
		do{
			//Increase i till the pivot is greater than arr[i]
			while(arr[i]<pivot)
				i++;
			//Decrease j till the pivot is smaller than arr[j]
			while(arr[j]>pivot)
				j--;
			//Swap elements at arr[i] with arr[j]; if i < j
			if(i<j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		} while(i<j);
		//Swap elements if pivot is greater than j
		if(arr[j]<pivot){
			arr[low] = arr[j];
			arr[j]=pivot;
		}
		return j;
	}
	

}
