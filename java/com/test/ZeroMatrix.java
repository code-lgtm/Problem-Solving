package com.test;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] mat = getRandMatrix(5,6);

		printMat(mat);
		zerofyMat(mat);
		printMat(mat);


	}

	private static void zerofyMat(int[][] mat) {

		boolean rowHadZeros = false, columnHadZeros = false;

		//check 0s in row
		for(int i = 0; i < mat[0].length; i++) {
			if(mat[0][i] == 0) {
				rowHadZeros = true;
				break;
			}
		}

		//check 0s in column
		for(int i = 0; i < mat.length; i++) {
			if(mat[i][0] == 0) {
				columnHadZeros = true;
				break;
			}

		}


		//reserving first row and column for storing deletion
		for(int i = 1; i < mat.length; i++) {
			for(int j = 1; j < mat[0].length; j++) {
				if(mat[i][j] == 0) {
					mat[i][0] = 0;//marking the row for deleting
					mat[0][j] = 0;//marking the column for deleting
				}
			}
		}
		
		for(int i = 1; i < mat[0].length; i++) {
			if(mat[0][i] == 0) {
				//set ith column to zero
				zerofyColumn(mat, i);
			}
		}
		
		for(int i = 1; i < mat.length; i++) {
			if(mat[i][0] == 0) {
				//set ith row to zero
				zerofyRow(mat, i);
			}
		}
		
		if(rowHadZeros) {
			for(int i = 0 ; i < mat[0].length; i++) {
				mat[0][i] = 0;
			}
		}
		
		if(columnHadZeros) {
			for(int i = 0 ; i < mat.length; i++) {
				mat[i][0] = 0;
			}
		}


	}
	
	private static void zerofyRow(int[][] mat, int row) {
		for(int i = 0 ; i < mat[0].length; i++) {
			mat[row][i] = 0;
		}
	}

	private static void zerofyColumn(int[][] mat, int column) {
		for(int i = 0 ; i < mat.length; i++) {
			mat[	column][i] = 0;
		}
	}


	/**Housekeeping code**/
	private static int[][] getRandMatrix(int x, int y) {
		int[][] mat = new int[x][y];
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				mat[i][j] = (int) (Math.random() * 10); 
			}
		}
		return mat;
	}
	private static void printMat(int[][] mat) {

		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	/**Housekeeping code**/

}
