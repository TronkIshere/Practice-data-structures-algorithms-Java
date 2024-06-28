package RealCombatProgramming;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode_Matrix {
    public int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix[0].length;
        int cols = matrix.length;
        for(int i = rows - 1; i >= 0; i--){
            int max = 0;
            for(int j = cols - 1; j >= 0; j--)
                if(matrix[j][i] > max) max = matrix[j][i];
            for(int j = cols - 1; j >= 0; j--)
                if(matrix[j][i] == -1) matrix[j][i] = max;
        }
        return matrix;
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length) return new int[0][0];
        int index = 0;
        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = original[index];
                index++;
            }
        }
        return result;
    }

    //By chicm
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Set<Integer> markedRows = new HashSet<>();
        Set<Integer> markedCols = new HashSet<>();
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(matrix[i][j] == 0){
                    markedRows.add(i);
                    markedCols.add(j);
                }
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(markedRows.contains(i) || markedCols.contains(j))
                    matrix[i][j] = 0;
    }

    public void setZeroesButFaster(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        int n =matrix.length;
        int m=matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{ i,j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] it = q.poll();
            int r = it[0];
            int c = it[1];
            for(int i=0;i<m;i++){
                matrix[r][i]=0;
            }
            for(int i=0;i<n;i++){
                matrix[i][c]=0;
            }
        }
    }

    public static void main(String[] args){
        Leetcode_Matrix lc = new Leetcode_Matrix();
        lc.setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }
}
