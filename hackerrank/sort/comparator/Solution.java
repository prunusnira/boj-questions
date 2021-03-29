package com.hackerrank.sort.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {

	@Override
	public int compare(Player arg0, Player arg1) {
		if(arg0.score > arg1.score) return -1;
		else if(arg0.score < arg1.score) return 1;
		else {
			// 동일한 score에 대해 이름 체크
			char[] arg0name = arg0.name.toCharArray();
			char[] arg1name = arg1.name.toCharArray();
			int length = arg0.name.length() > arg1.name.length() ? arg1.name.length() : arg0.name.length();
			
			for(int i = 0; i < length; i++) {
				if(arg0name[i] == arg1name[i]) continue;
				else if(arg0name[i] > arg1name[i]) return 1;
				else return -1;
			}
			
			if(arg0.name.length() == arg1.name.length()) return 0;
			else if(arg0.name.length() > arg1.name.length()) return 1;
			else return -1;
		}
	}
	
}

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
