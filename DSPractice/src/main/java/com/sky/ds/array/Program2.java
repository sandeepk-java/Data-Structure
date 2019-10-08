package com.sky.ds.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Find missing number in array without using any extra space 
 * 
 * 
 * Given a limited range array of size n where array contains elements between 1 to n+1 with one
 * element missing, find the missing number without using extra space.
 * Input : {3,2,4,6,1}
 * Output: 5 
 * Input : {3,2,4,5,6}
 * Output: 1
 * Input : {3,2,4,5,1}
 * Output: 6  
 * @author sandeepkumar
 *
 */
public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int size = sc.nextInt();
		int[] inputArray = new int[size-1];
		System.out.println("Enter elements in array: ");
		for(int i=0;i<size-1;i++)
			inputArray[i] = sc.nextInt();
		//Sum of first N number = n*(n+1)/2;
		int sumOfFirstNNumber = size*(size+1)/2;
		int sumOfInput = Arrays.stream(inputArray).sum();
		int missingNumber = sumOfFirstNNumber - sumOfInput;
		System.out.println("Missing number is : "+missingNumber);
	}
}
