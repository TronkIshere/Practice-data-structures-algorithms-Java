package RealCombatProgramming;

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
}
