class Solution {
    public int maxProfit(int[] stockPrices) {
        int profit = 0;
        int start = 0;

        for(int i =1;i<stockPrices.length;i++){
            if(stockPrices[start]<stockPrices[i]){
                profit += (stockPrices[i]-stockPrices[start]);
            }
            start = i;
        }
        return profit;
    }
}