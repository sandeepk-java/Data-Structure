package com.sky.ds.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Find all elements in an array that are greater than all elements present to their right
 * input: 10,4,6,3,5
 * output: 10,6,5
 * @author sandeepkumar
 *
 */
public class Program1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter no of elements in the array: ");
		int size = in.nextInt();
		int sourceArray[] = new int[size];
		System.out.println("Enter the elements in the array");
		for(int i=0;i<size;i++){
			sourceArray[i] = in.nextInt();
		}
		//Time complexity of the above loop is O(n)
		System.out.println(resultantArray(sourceArray));
		
	}
	
	public static List<Integer> resultantArray(int[] source){
		List<Integer> result = new ArrayList<>();
		for(int i=0;i<source.length;i++){
			boolean isGreater = true;
			int number = source[i];
			for(int j=i+1;j<source.length;j++){
				if(number<source[j]){
					isGreater = false;
					break;
				}
			}
			if(isGreater){
				result.add(number);
			}
		}
		return result; 
	}

}
