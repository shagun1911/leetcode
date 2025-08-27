import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] inter = new int[n+1][2];
       
        inter[0] = newInterval;

        for (int i = 0; i < intervals.length; i++) {
            inter[i+1] = intervals[i];
        }

        Arrays.sort(inter, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] prev = inter[0];

        for (int i = 1; i < inter.length; i++) {
            int[] curr = inter[i];
            if (curr[0] <= prev[1]) {  
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                merged.add(prev);
                prev = curr;
            }
        }

        merged.add(prev);

        return merged.toArray(new int[merged.size()][]); 
    }
}
