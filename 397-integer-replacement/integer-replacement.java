import java.util.*;

class Solution {
    private int helper(long n, Map<Long, Integer> dp) {
        if (n == 1) return 0;

        if (dp.containsKey(n)) return dp.get(n);

        int steps;
        if (n % 2 == 0) {
            steps = 1 + helper(n / 2, dp);
        } else {
            int plus = 1 + helper(n + 1, dp);
            int minus = 1 + helper(n - 1, dp);
            steps = Math.min(plus, minus);
        }

        dp.put(n, steps);
        return steps;
    }

    public int integerReplacement(int n) {
        Map<Long, Integer> dp = new HashMap<>();
        return helper(n, dp);
    }
}
