class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int curEmpty = numBottles;

        while(curEmpty/numExchange!=0){
            int gotExchanged = curEmpty/numExchange;
            int leftEmpty = curEmpty - gotExchanged * numExchange;
            res += gotExchanged;
            curEmpty = leftEmpty + gotExchanged;
        }
        return res;
    }
}