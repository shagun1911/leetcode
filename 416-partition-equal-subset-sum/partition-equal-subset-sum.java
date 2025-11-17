import java.util.*;

class Solution {
    private boolean helper(int index, int target, int[] nums, int[][] dp) {
        if (target == 0) return true; 
        if (index == 0) return nums[0] == target;
        if (dp[index][target] != -1) return dp[index][target] == 1;

        boolean notPick = helper(index - 1, target, nums, dp);

        boolean pick = false;
        if (nums[index] <= target) {
            pick = helper(index - 1, target - nums[index], nums, dp);
        }

        dp[index][target] = (pick || notPick) ? 1 : 0;
        return pick || notPick;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for (int num : nums) totalSum += num;

        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        int [][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1); 

        return helper(n - 1, target, nums, dp);
    }
}
