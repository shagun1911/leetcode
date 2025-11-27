class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        long prefix = 0;

        long[] minPrefix = new long[k];
        for (int i = 0; i < k; i++) minPrefix[i] = Long.MAX_VALUE;

        minPrefix[0] = 0;

        long maxSum = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            prefix += nums[i];  

            int mod = (i + 1) % k;

            if (minPrefix[mod] != Long.MAX_VALUE) {
                long candidate = prefix - minPrefix[mod];
                maxSum = Math.max(maxSum, candidate);
            }

            minPrefix[mod] = Math.min(minPrefix[mod], prefix);
        }

        return maxSum;
    }
}
