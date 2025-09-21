class Solution {
    public int change(int amount, int[] coins) {
         int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, amount, coins, dp);
    }

    private int solve(int index, int target, int[] coins, int[][] dp) {
        if (index == 0) {
            return (target % coins[0] == 0) ? 1 : 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notPick = solve(index - 1, target, coins, dp);
        int pick = 0;
        if (coins[index] <= target) {
            pick = solve(index, target - coins[index], coins, dp);
        }

        return dp[index][target] = pick + notPick;
    }
}