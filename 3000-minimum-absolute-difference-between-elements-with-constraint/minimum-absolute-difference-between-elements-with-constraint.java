import java.util.*;

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        TreeSet<Integer> set = new TreeSet<>();
        int res = Integer.MAX_VALUE;

        for (int j = x; j < n; j++) {
            set.add(nums.get(j - x));

            int val = nums.get(j);

            Integer floor = set.floor(val);
            if (floor != null) {
                res = Math.min(res, Math.abs(val - floor));
            }

            Integer ceil = set.ceiling(val);
            if (ceil != null) {
                res = Math.min(res, Math.abs(val - ceil));
            }
        }

        return res;
    }
}
