package com.hackerrank.sort.bubblesort;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        bSort(a, n);
    }
    
    public static void bSort(int[] a, int n) {
    	int totalSwap = 0;
    	for (int i = 0; i < n; i++) {
    	    // Track number of elements swapped during a single array traversal
    	    int numberOfSwaps = 0;
    	    
    	    for (int j = 0; j < n - 1; j++) {
    	        // Swap adjacent elements if they are in decreasing order
    	        if (a[j] > a[j + 1]) {
    	            swap(a, j);//a[j], a[j + 1]);
    	            numberOfSwaps++;
    	        }
    	    }
    	    
    	    // If no elements were swapped during a traversal, array is sorted
    	    if (numberOfSwaps == 0) {
    	        break;
    	    }
    	    totalSwap += numberOfSwaps;
    	}
    	
    	System.out.println("Array is sorted in "+totalSwap+" swaps.");
    	System.out.println("First Element: "+a[0]);
    	System.out.println("Last Element: "+a[n-1]);
    }
    
    public static void swap(int[] a, int i) {
    	int temp = a[i+1];
    	a[i+1] = a[i];
    	a[i] = temp;
    }
}