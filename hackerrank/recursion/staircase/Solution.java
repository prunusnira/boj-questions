package com.hackerrank.recursion.staircase;

import java.util.Scanner;

// Solved with dynamic programming
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(calculate(n));
        }
    }
    
    public static int calculate(int n) {
    	int dp[] = new int[n+1];
    	dp[1] = 1;
    	if(n > 1) dp[2] = 2;
    	if(n > 2) dp[3] = 4;
    	for(int i = 4; i <= n; i++) {
    		dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
    	}
    	return dp[n];
    }
}
