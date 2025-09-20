import java.util.*;

class Solution {
    private int memoization(int i, int[] nums, int[][] dp, int sum, int target) {
        if (i < 0) {
            return (sum == target) ? 1 : 0;
        }

        if (dp[i][sum + 1000] != -1) return dp[i][sum + 1000];

        int add = memoization(i - 1, nums, dp, sum + nums[i], target);
        int sub = memoization(i - 1, nums, dp, sum - nums[i], target);

        return dp[i][sum + 1000] = add + sub;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][2001];
        for (int[] row : dp) Arrays.fill(row, -1);

        return memoization(n - 1, nums, dp, 0, target);
    }

}
