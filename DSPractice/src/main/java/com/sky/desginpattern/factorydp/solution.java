package com.sky.desginpattern.factorydp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            int number = sc.nextInt();
            int permutedSumOfBits = getPermutedSumOfBits(number);
            System.out.println(permutedSumOfBits);
            
        }

    }
    
    static Set<String> permutedBits = new HashSet<String>();
    public static int getPermutedSumOfBits(int number){
        String bits = Integer.toBinaryString(number);
        int bitLength = bits.length();
        getPermutation(bits,0,bitLength-1);
        int sum = 0;
        for(String s: permutedBits){
            //int i = Integer.parseInt(s, 2);
            sum+=Integer.parseInt(s, 2);
        }
        return sum;
    
    }
    
    public static void getPermutation(String s,int left, int right){
        if (left == right) {
    		permutedBits.add(s);
    	}
        else
        { 
            for (int i = left; i <= right; i++) 
            { 
                s = swapCharacter(s,left,i); 
                getPermutation(s, left+1, right); 
                s = swapCharacter(s,left,i);
            } 
        }
    }
    
    public static String swapCharacter(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    }
}
