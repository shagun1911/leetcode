import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

 
        for (int j = 0; j < m; j++) {
            dp[n-1][j] = matrix[n-1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int down = dp[i+1][j];
                int leftDiag = (j > 0) ? dp[i+1][j-1] : Integer.MAX_VALUE;
                int rightDiag = (j < m-1) ? dp[i+1][j+1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, dp[0][j]);
        }

        return minSum;
    }
}
