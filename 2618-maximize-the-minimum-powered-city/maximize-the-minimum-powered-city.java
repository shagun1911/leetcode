class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] power = new long[n];
        long[] prefix = new long[n + 1];
        
        // Step 1: Prefix sum to calculate initial power
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stations[i];
        }

        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = prefix[right + 1] - prefix[left];
        }

        // Step 2: Binary search on answer
        long low = 0, high = (long) 1e18, ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (canAchieve(mid, power.clone(), r, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAchieve(long minPower, long[] power, int r, long k) {
        int n = power.length;
        long used = 0;
        long[] add = new long[n + 1];  
        long currAdd = 0;

        for (int i = 0; i < n; i++) {
            currAdd += add[i];
            power[i] += currAdd;

            if (power[i] < minPower) {
                long need = minPower - power[i];
                used += need;
                if (used > k) return false;

                power[i] += need;
                currAdd += need;
                if (i + 2 * r + 1 < n) add[i + 2 * r + 1] -= need;
            }
        }
        return true;
    }
}
