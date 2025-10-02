class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drank = numBottles; 
        int empty = numBottles;

        while (empty >= numExchange) {
            empty -= numExchange; 
            drank++;             
            empty++;              
            numExchange++;       
        }

        return drank;
    }
}
