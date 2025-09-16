import java.util.*;

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> freq = new HashMap<>();
        long pairs = 0;

        for (int[] rect : rectangles) {
            double ratio = (double) rect[0] / rect[1]; 
            long count = freq.getOrDefault(ratio, 0L);
            
            pairs += count; 
            
            freq.put(ratio, count + 1);
        }

        return pairs;
    }
}
