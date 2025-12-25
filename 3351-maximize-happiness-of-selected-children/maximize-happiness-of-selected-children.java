class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long sum = 0;
        int count = 0;
        int n = happiness.length;

        for (int i = n - 1; i >= 0 && k > 0; i--) {
            int current = happiness[i] - count;
            if (current > 0) {
                sum += current;
            }
            count++;
            k--;
        }

        return sum;
    }
}
