class Solution {
    boolean isValid(int divisor, int[] nums, int threshold){
        int t = 0;

        for (int num : nums) {
            t += (int)Math.ceil((double) num / divisor); 
        }

        return t <= threshold; 
    }

    private int max(int[] nums){
         int a = 0;

        for(int num: nums){
            a = Math.max(a, num);
        }
        return a;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        
        int left = 1;       
        int right = max(nums);       
        int answer = right;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if (isValid(mid, nums, threshold)) {
                
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
