class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int count = 0;
        int n = numBottles;
        while(numBottles >= numExchange){
            numBottles = numBottles - numExchange;
            if(numBottles>=0){
                count++;
            }
            numExchange++;
            numBottles++;
        }
        
        return count+n;
    }
}