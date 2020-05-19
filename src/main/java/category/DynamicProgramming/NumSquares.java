package category.DynamicProgramming;

import java.util.Arrays;

/**
 * @author yzchen
 * @create 2020-04-17
 * @desc
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 *
 *
 * 完全平方数
 *
 **/
public class NumSquares {

    /**
     *
     * **/
    public int numSquares(int n) {

        // 预处理数据
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; i++) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; s++) {
                if (i < square_nums[s]){
                    break;
                }
                // 两个数之间只差一个 平方数
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }




}
