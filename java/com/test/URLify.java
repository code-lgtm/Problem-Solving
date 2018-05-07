package com.test;

public class URLify {

	public static void main(String[] args) {

		char[] url = urlify("Me John Smith    ".toCharArray());
		System.out.println(url);
	}

	private static char[] urlify(char[] url) {
		
		int pTail = url.length - 1, pFront = url.length-1;
		for(int i = pFront; i >=0 ; i--) {
			if(url[i] !=' ') {
				pFront = i;
				break;
			}
		}
		
		while(pFront > 0) {
			if(url[pFront] == ' ') {
				url[pTail--] = '0';
				url[pTail--] = '2';
				url[pTail--] = '%';
			}else {
				url[pTail--] = url[pFront];
			}
			--pFront;
		}
		
		
		return url;
	}

}
