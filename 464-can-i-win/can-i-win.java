import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Boolean> memo;
    int max;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) return false; 
        if (desiredTotal <= 0) return true;   

        memo = new HashMap<>();
        this.max = maxChoosableInteger;
        return canWin(0, desiredTotal); 
    }

    private boolean canWin(int usedMask, int target) {
        if (target <= 0) return false; 

        if (memo.containsKey(usedMask)) return memo.get(usedMask);

        for (int i = 1; i <= max; i++) {
            int curBit = 1 << (i - 1);
            if ((usedMask & curBit) != 0) continue; 

            
            if (i >= target || !canWin(usedMask | curBit, target - i)) {
                memo.put(usedMask, true);
                return true;
            }
        }

        memo.put(usedMask, false);
        return false;
    }
}
