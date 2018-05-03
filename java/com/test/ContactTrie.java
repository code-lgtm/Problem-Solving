package com.test;

class TNode{
	char c;
	boolean completed = false;
	TNode[] tn = new TNode[26];

}

public class ContactTrie {
	static TNode root = new TNode();

	public static void main(String[] args) {
		addString("prashant");
		addString("prisha");

		int count = matchCnt("apr");

		System.out.println(count);	
	}

	private static int matchCnt(String ip) {
		TNode next = root;
		char[] ipAry = ip.toCharArray();
		for(int i = 0; i< ipAry.length; i++) {
			int ind = ipAry[i] - 'a';
			if(next == null || next.tn[ind] == null) {
				return 0;
			}
			next = next.tn[ind];
		}
		//prefix has matched, we need to count the matching number

		return getCnt(next);
	}

	private static int getCnt(TNode next) {
		int matches = 0;
	
		if(next.completed) {
			matches++;
		}
		
		for(TNode n: next.tn) {
			if(n!=null) {
				matches = matches + getCnt(n);
			}
		}
		
		return matches;
	}

	public static void addString(String ip) {
		char[] ipAry = ip.toCharArray();

		TNode next = root;
		for(int i = 0; i< ipAry.length; i++) {
			int ind = ipAry[i] - 'a';

			if(next.tn[ind] == null) {
				next.tn[ind] = new TNode();
				next.tn[ind].c = ipAry[i];
				if(i == ipAry.length -1) {//last char
					next.tn[ind].completed = true;
				}
			}

			next = next.tn[ind];

		}
	}

}
