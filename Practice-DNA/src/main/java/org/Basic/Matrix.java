package org.Basic;

public class Matrix {
    public void search(int[][] matrix, int n , int x){
        int i = 0;
        int j = 0;
        while (i < n && j >= 0) {
            if (matrix[i][j] == x)
                System.out.println("x found at: " + i + ", " + j);
            if(matrix[i][j] > x)
                j--;
            else
                i++;
        }
    }

    void spiralPrint(int[][] matrix, int r, int c){
        int i, k = 0, l = 0;
        while(k < r && l < c){
            for(i = l; i < c; i++)
                System.out.printf(matrix[k][i] + " ");
            k++;

            for(i = k; i < r; i++)
                System.out.printf(matrix[i][c-1] + " ");
            c--;

            if(k < r) {
                for(i = c - 1; i >= l; i--)
                    System.out.printf(matrix[r-1][i] + " ");
                r--;
            }

            if(l < c){
                for(i = r - 1; i >= k; i--)
                    System.out.printf(matrix[i][l] + " ");
                l++;
            }
        }
    }

    public static void main(String[] args){
        int[][] sortedMatrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };
        Matrix matrix = new Matrix();
        matrix.search(sortedMatrix, sortedMatrix.length, 32);

        System.out.println("Spiral print matrix: ");
        matrix.spiralPrint(sortedMatrix, 4, 4);
    }
}
