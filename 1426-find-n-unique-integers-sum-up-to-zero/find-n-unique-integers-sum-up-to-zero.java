class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if(n%2 == 0){
        for(int i = 0; i<n/2; i++){
           result[i] = -i-1;
        }
        int a = 0;
        for(int i = n/2; i<n; i++){
            result[i] = a+1;
            a++;
        }
        }
        if(n%2 != 0){
        for(int i = 0; i<n/2; i++){
           result[i] = -i-1;
        }
        result[n/2] = 0;
        int b = 0;
        for(int i = n/2+1; i<n; i++){
            result[i] = b+1;
            b++;
        }
        }
        return result; 
    }
}