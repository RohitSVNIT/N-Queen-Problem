import java.util.*;
import java.lang.*;

class NQueen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NQueen ob = new NQueen();
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		if(ob.solveBoard(a,n,0)) {
			System.out.println("Solution Doesn't Exist");
		}
	}

	public void printBoard(int a[][], int n) {
		for(int i=0 ; i<n ; i++) {
			for(int j=0; j<n ; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	boolean isSafe(int a[][], int n,int row,int col) {
		// Check row in Left Side
		for(int i=0 ; i<col ; i++) {
			if(a[row][i] == 1) {
				return false;
			}
		}

		// Check upper diagonal on left side
		for(int i=row, j=col ; i>=0 && j>=0 ; i--, j--) {
			if(a[i][j] == 1) {
				return false;
			}
		}

		// Check upper diagonal on right side
		for(int i=row, j=col ; i<n && j>=0 ; i++,j--) {
			if(a[i][j] == 1) {
				return false;
			}
		}

		// Safe Position
		return true;
	}

	boolean solveBoard(int a[][], int n, int col) {
		if(col == n) {
			printBoard(a,n);
		}

		for(int i=0 ; i<n ; i++) {
			if(isSafe(a,n,i,col)) {
				a[i][col] = 1;
				solveBoard(a,n,col+1);
				a[i][col] = 0;			// Backtrack
			}
		}
		return false;
	}
}
