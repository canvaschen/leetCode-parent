package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2020-05-13
 * @desc
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 * 零钱兑换
 *
 **/
public class CoinChange {


    public int coinChange(int[] coins, int amount) {
        if (amount < 1){
            return 0;
        }

        // 初始化 数组大小 : amount
        return coinChange(coins, amount, new int[amount]);
    }



    /**
     * 动态规划 ，自上而下
     *
     * dp []  硬币的个数
     *
     * dp[amount - 1] : amount 是 数组长度 ，index 是  0 -- amount-1
     *
     * **/
    private int coinChange(int[] coins, int amount, int[] dp) {
        if (amount < 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        if (dp[amount - 1] != 0){
            return dp[amount - 1];
        }
        int min = Integer.MAX_VALUE;


        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, dp);
            if (res >= 0 && res < min){
                min = 1 + res;
            }
        }
        dp[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount - 1];
    }











}
