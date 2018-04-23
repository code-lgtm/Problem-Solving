package com.test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MyQueue<T>{

	private Stack<Integer> in = new Stack<Integer>();
	private Stack<Integer> out = new Stack<Integer>();	
	boolean wasLastEnqueuedOrPeek = false;
	Integer cachedPeek = null;
	
	public void enqueue(int i) {
		in.push(i);
	}

	public Integer peek() {
	
		if(out.isEmpty()) {
			while(! in.isEmpty()) {
				out.push(in.pop());
			}
		}
		
		return out.isEmpty()? null: out.peek();
	}

	public Integer dequeue() {
		if(out.isEmpty()) {
			while(! in.isEmpty()) {
				out.push(in.pop());
			}
		}
		
		return out.isEmpty()? null: out.pop();
	}
		
	
}


public class QueueUsingStack {


    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
