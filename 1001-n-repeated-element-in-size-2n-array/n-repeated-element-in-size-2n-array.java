class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int a = nums.length;
        int n = a/2;

        for(int i =0; i<a-1; i++){
           if(nums[i]==nums[i+1]){
            n = nums[i];
           }
        }
        return n;
    }
}