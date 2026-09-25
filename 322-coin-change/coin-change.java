import java.util.Arrays;
//hii
class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] will store the minimum coins needed for amount i
        int[] dp = new int[amount + 1];
        
        // Fill the array with a sentinel value (amount + 1 acts as infinity)
        // Since the smallest coin value is 1, you can never need more than 'amount' coins.
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins are needed to make an amount of 0
        dp[0] = 0;
        
        // Iterate through all sub-amounts from 1 up to the target amount
        for (int i = 1; i <= amount; i++) {
            // Check every coin denomination
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] wasn't updated, it means the amount cannot be formed
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
