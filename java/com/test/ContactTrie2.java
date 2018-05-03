package com.test;

class TrNode{
	char c;
	boolean completed = false;
	int childCnt = 0;
	TrNode[] tn = new TrNode[26];

}

public class ContactTrie2 {
	static TrNode root = new TrNode();

	public static void main(String[] args) {
		addString("s");
		addString("ss");
		addString("sss");
		addString("ssss");
		addString("sssss");

		addString("prashant");
		addString("prisha");
		addString("nitika");
		//int count = matchCnt("apr");

		System.out.println(matchCnt("s"));	
		System.out.println(matchCnt("ss"));
		System.out.println(matchCnt("sss"));
		System.out.println(matchCnt("ssss"));
		System.out.println(matchCnt("sssss"));
		System.out.println(matchCnt("ssssss"));
	}

	private static int matchCnt(String ip) {
		TrNode next = root;
		char[] ipAry = ip.toCharArray();
		for(int i = 0; i< ipAry.length; i++) {
			int ind = ipAry[i] - 'a';
			if(next == null || next.tn[ind] == null) {
				return 0;
			}
			
			next = next.tn[ind];
		}
		//prefix has matched, we need to count the matching number

		return next.childCnt;
	}


	public static void addString(String ip) {
		char[] ipAry = ip.toCharArray();

		TrNode next = root;
		for(int i = 0; i< ipAry.length; i++) {
			int ind = ipAry[i] - 'a';

			if(next.tn[ind] == null) {
				next.tn[ind] = new TrNode();
				next.tn[ind].c = ipAry[i];
				//next.tn[ind].childCnt = 1;//new node will have just itself as child
				if(i == ipAry.length -1) {//last char
					next.tn[ind].completed = true;
				}
			}

			next.tn[ind].childCnt++;
			next = next.tn[ind];
		}
	}

	
	
}
