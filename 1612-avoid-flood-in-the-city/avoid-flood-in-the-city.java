import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> fullLakeDay = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1; 
            } else {
                int lake = rains[i];
                ans[i] = -1;

                if (fullLakeDay.containsKey(lake)) {
                    int lastRainDay = fullLakeDay.get(lake);
                    Integer dryDay = dryDays.higher(lastRainDay);

                    if (dryDay == null)
                        return new int[0]; 

                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }

                fullLakeDay.put(lake, i);
            }
        }
        return ans;
    }
}
