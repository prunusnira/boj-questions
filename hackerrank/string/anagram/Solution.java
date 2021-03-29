package com.hackerrank.string.anagram;

import java.util.Scanner;

public class Solution {
    public static int numberNeeded(String first, String second) {
    	// string을 분해하여 각 단어 수를 기록하는 배열에 저장 후 개수 비교하기
    	int fsize[] = new int[26];
    	int ssize[] = new int[26];
    	
    	// 초기화
    	for(int i = 0; i < 26; i++) {
    		fsize[i] = 0;
    		ssize[i] = 0;
    	}
    	
    	char farr[] = first.toCharArray();
    	for(char c:farr) {
    		fsize[c-97]++;
    	}
    	char sarr[] = second.toCharArray();
    	for(char c:sarr) {
    		ssize[c-97]++;
    	}
    	
    	int diffsize = 0;
    	for(int i = 0; i < 26; i++) {
    		diffsize += Math.abs(fsize[i]-ssize[i]);
    	}
    	return diffsize;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}