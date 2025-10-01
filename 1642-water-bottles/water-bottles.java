class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        int n = numBottles;
        while(numBottles >= numExchange){
            count = count + numBottles/numExchange;
            numBottles = numBottles/numExchange + numBottles%numExchange;
        }
        return count + n;
    }
}