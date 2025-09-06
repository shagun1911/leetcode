class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;

        for (int[] q : queries) {
            long l = q[0], r = q[1];
            long totalSteps = 0;

            long power = 1; 
            int step = 1;  

            while (power <= r) {
                long start = power;
                long end = Math.min(r, power * 4 - 1);

                if (end >= l) {
                    long left = Math.max(l, start);
                    long right = end;
                    long count = right - left + 1;
                    if (count > 0) {
                        totalSteps += count * step;
                    }
                }

                power *= 4;
                step++;
            }

            ans += (totalSteps + 1) / 2;
        }

        return ans;
    }
}
