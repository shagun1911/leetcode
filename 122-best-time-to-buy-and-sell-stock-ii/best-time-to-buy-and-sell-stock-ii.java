class Solution {
    public int maxProfit(int[] prices) {
     int profit = 0; 
     int n = prices.length;

     for(int i = 0; i < n-1; i++){
        int prf = prices[i+1] - prices[i];
        if(prf > 0){
            profit = profit + prf;
        }
     } 
     return profit;

    }
}