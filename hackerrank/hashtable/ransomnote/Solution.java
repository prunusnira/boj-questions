package com.hackerrank.hashtable.ransomnote;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public Solution(String magazine, String note) {
    	// Integer가 있는 이유는 동일한 단어의 수 확인용
    	magazineMap = new HashMap<>();
    	noteMap = new HashMap<>();
    	
        String magarr[] = magazine.split(" ");
        String notearr[] = note.split(" ");
        
        for(String s:magarr) {
        	if(magazineMap.containsKey(s))
        		magazineMap.put(s, magazineMap.get(s)+1);
        	else
        		magazineMap.put(s, 1);
        }
        
        for(String s:notearr) {
        	if(noteMap.containsKey(s))
        		noteMap.put(s, noteMap.get(s)+1);
        	else
        		noteMap.put(s, 1);
        }
    }
    
    public boolean solve() {
    	Set<String> keys = noteMap.keySet();
    	for(String k:keys) {
    		if(!magazineMap.containsKey(k)) {
    			return false;
    		}
    		else if(magazineMap.get(k) < noteMap.get(k)) {
    			return false;
    		}
    	}
    	return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
