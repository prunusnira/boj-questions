package com.hackerrank.recursion.fibonacci;

import java.util.Scanner;

public class Solution {

    
    public static int fibonacci(int n) {
        // Complete the function.
    	if(n == 1) return 1;
    	else if(n == 0) return 0;
    	else return fibonacci(n-1)+fibonacci(n-2);
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}