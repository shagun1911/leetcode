class Solution {
    public int[] getSneakyNumbers(int[] nums) {
      int[] res = new int[2];
       Arrays.sort(nums);
       int a = 0;

       for(int i = 0; i<nums.length-1; i++){
          if(nums[i]==nums[i+1]){
            res[a] = nums[i];
            i++;
            a++;
          }
       }

       return res;

    }
}