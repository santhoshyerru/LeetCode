class Solution {
     private int func(int[] coins, int amount, int index, int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            else return Integer.MAX_VALUE;
        }
        
        if (dp[index][amount] != -1) return dp[index][amount];
        
        int notTake = func(coins, amount, index - 1, dp);
        int take = Integer.MAX_VALUE;
        
        if (coins[index] <= amount) {
            int result = func(coins, amount - coins[index], index, dp);
            if (result != Integer.MAX_VALUE) take = 1 + result;
        }
        
        return dp[index][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
          if (amount == 0) return 0;
        
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int ans = func(coins, amount, coins.length - 1, dp);
        
        return (ans >= Integer.MAX_VALUE) ? -1 : ans;
    }
}