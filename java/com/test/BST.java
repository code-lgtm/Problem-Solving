package com.test;

import java.util.Arrays;

class Node{
	int data;
	Node left;
	Node right;
	public Node() {}
	public Node(int value, Node left, Node right) {
		this.data = value;
		this.left = left;
		this.right = right;
	}
}
public class BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] ip = {8,10,15,12,20,17,25};
		Arrays.sort(ip);
		
		Node bst = createBst(ip, 0, ip.length-1);
	//	printPreorder(bst);
	//	printPostorder(bst);
		System.out.println(validateBst(bst, Integer.MIN_VALUE, Integer.MAX_VALUE)?"YES":"NO");

	}

	private static boolean validateBst(Node bst, int min, int max) {

		if(bst ==  null) return true;
		
		if(bst.data < min || bst.data > max ) {
			return false;
		}
		
//		if (validateBst(bst.left, min, bst.value) && validateBst(bst.right, bst.value, max)) {
//			return true;
//			
//		}
		return validateBst(bst.left, min, bst.data-1) && validateBst(bst.right, bst.data+1, max);
	}

	private static Node createBst(int[] ip, int min, int max) {
		if (min > max) {
			return null;
		}
		int mid = (min + max)/2;
		Node n = new Node();
		n.data = ip[mid];
		n.left = createBst(ip, min, mid-1);
		n.right = createBst(ip, mid+1, max);
		return n;
	}
	
	//data left right
	private static void printPreorder(Node bst) {
		if(bst ==  null) return;
		
		int value = bst.data;
		System.out.print(value +" ");
		printPreorder(bst.left);
		printPreorder(bst.right);
		
	}
	
	// left right data
		private static void printPostorder(Node bst) {
			if(bst ==  null) return;
			printPostorder(bst.left);
			printPostorder(bst.right);
			int value = bst.data;
			System.out.print(value +" ");
			
			
		}

}
