package com.hackerrank.tree.contact;

import java.util.*;

// TESTCASE 3,4 시간부족
public class Solution {
	
	class Node {
		char data;
		ArrayList<Node> next;
		boolean end;
		
		public Node() {
			next = new ArrayList<>();
			end = false;
		}
	}
	
	public Solution() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        Node topnode = new Node();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            runOperation(topnode, op, contact);
            
            // 모든 항목 출력
            //printAll(topnode);
        }
	}

    public static void main(String[] args) {
        new Solution();
    }
    
    public void runOperation(Node node, String op, String contact) {
    	switch(op) {
        case "add":
        	// 새 string 추가하기
        	addNewString(node, contact);
        	break;
        case "find":
        	findString(node.next, contact);
        	System.out.println(subsize);
        	subsize = 0;
        	break;
        }
    }
    
    public void addNewString(Node node, String contact) {
    	// 추가 할 문자
    	char c = contact.charAt(0);
    	
    	// 이 문자가 들어있는지 확인
    	ArrayList<Node> nextnodes = node.next;
    	Node nextNodeCheck = isCharExist(nextnodes, c);
    	if(nextNodeCheck != null) {
    		// 해당 문자가 있는 노드를 가져와서 새 문자를 추가
    		addNewString(nextNodeCheck, contact.substring(1));
    	}
    	else {
    		// 문자가 없으면 새 문자를 arraylist에 추가
    		node.next.add(addNewNode(contact));
    	}
    }
    
    public Node isCharExist(ArrayList<Node> nodes, char c) {
    	Iterator<Node> itor = nodes.iterator();
    	while(itor.hasNext()) {
    		Node n = itor.next();
    		if(n.data == c) return n;
    	}
    	return null;
    }
    
    public Node addNewNode(String contact) {
    	Node newNode = new Node();
    	if(contact.length() > 1) {
    		newNode.data = contact.charAt(0);
    		newNode.next.add(addNewNode(contact.substring(1)));
    	}
    	else if(contact.equals("*")) {
    		newNode.data = '*';
    		newNode.next = null;
    	}
    	else {
    		newNode.data = contact.charAt(0);
    		newNode.next.add(addNewNode("*"));
    	}
    	return newNode;
    }
    
    public void findString(ArrayList<Node> node, String contact) {
    	char c = contact.charAt(0);
    	Node found = isCharExist(node, c);
    	if(isCharExist(node, c) != null) {
    		// contact가 끝났으면 하위의 리프노드 개수 탐색
    		if(contact.length() == 1) {
    			getSize(found.next);
    		}
    		// 아니면 하위 노드로 계속 찾기
    		else {
    			findString(found.next, contact.substring(1));
    		}
    	}
    }
    
    int subsize = 0;
    public void getSize(ArrayList<Node> node) {
    	Iterator<Node> nodes = node.iterator();
    	while(nodes.hasNext()) {
    		Node c = nodes.next();
    		if(c.data == '*') {
    			subsize++;
    		}
    		else {
    			getSize(c.next);
    		}
    	}
    }
    
    public void printAll(Node top) {
    	Iterator<Node> nodes = top.next.iterator();
    	while(nodes.hasNext()) {
    		Node c = nodes.next();
    		System.out.println(c.data);
    		if(c.next != null) printAll(c);
    	}
    }
}
