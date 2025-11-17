class Solution {
    private int helper(int i, int j,int [][] grid, int dp[][]) {
       if(i == 0 && j == 0) return grid[0][0];
       if(j<0 || i <0) return Integer.MAX_VALUE;
       if(dp[i][j] != -1) return dp[i][j];

       int up = helper(i-1, j, grid , dp);
       int left = helper(i , j-1 , grid , dp);

      return dp[i][j] = grid[i][j] + Math.min(left,up);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
         int dp[][] = new int[m][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(m - 1, n - 1,grid, dp);
    }
}