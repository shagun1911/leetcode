class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        
        for(int i = 1; i < n; i++){
            int a = i;
            int b = n - i;
            
            if(isNoZero(a) && isNoZero(b)){
                res[0] = a;
                res[1] = b;
                return res;
            }
        }
        return res; 
    }
    

    private boolean isNoZero(int num){
        while(num > 0){
            if(num % 10 == 0) return false;
            num /= 10;
        }
        return true;
    }
}
