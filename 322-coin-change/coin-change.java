import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int ans = solve(0, amount, coins, dp);
        return ans >= (int)1e9 ? -1 : ans; 
    }

    private int solve(int index, int target, int[] coins, int[][] dp) {
       if (0 == target) return 0;
       if (index == coins.length || target<0) return (int)1e9;
        if (dp[index][target] != -1) return dp[index][target];

        int notPick = solve(index + 1, target, coins, dp);
        int pick = (int)1e9;
        if (coins[index] <= target) {
            pick = 1 + solve(index, target - coins[index], coins, dp);
        }

        return dp[index][target] = Math.min(pick, notPick);
    }
}
