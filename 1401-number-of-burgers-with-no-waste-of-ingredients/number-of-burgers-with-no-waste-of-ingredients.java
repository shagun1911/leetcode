import java.util.*;

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();

        if (tomatoSlices % 2 != 0) return res;

        int x = (tomatoSlices - 2 * cheeseSlices) / 2; 
        int y = cheeseSlices - x;

        if (x >= 0 && y >= 0 && (4 * x + 2 * y == tomatoSlices)) {
            res.add(x);
            res.add(y);
        }
        return res;
    }
}
