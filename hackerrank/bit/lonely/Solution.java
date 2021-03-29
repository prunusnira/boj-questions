package com.hackerrank.bit.lonely;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    public static int lonelyInteger(int[] a) {
    	int v = 0;
    	for(int c:a) {
    		v ^= c;
    	}
    	return v;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }
}