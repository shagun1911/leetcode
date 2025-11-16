class Solution {
    public int numSub(String s) {
        int M = 1_000_000_007;
        long ans = 0;
        long count1 = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count1++;
                ans = (ans + count1) % M; 
            } else count1 = 0;
        }

        return (int) ans;
    }
}