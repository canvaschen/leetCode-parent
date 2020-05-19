package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2020-04-14
 * @desc
 *
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 *
 * 最长回文子序列
 *
 **/
public class LongestPalindromeSubseq {


    public static void main(String []args){


        longestPalindromeSubseq("23122");

    }

    /**
     * 最长回文子序长度 :
     *
     * dp[i][j] : i 到 j 的最大回文子序列长度
     *
     * if i,j 相同的话:  dp[i][j] = dp[i + 1][j - 1] + 2;
     * if i,j 不同的话: dp[i][j] = max(dp[i][j-1],dp[i+1][j]);
     *
     * 顺序比较的巧妙 : i 递减，j 从 i 开始 递增
     *
     *            i
     *          i j
     *         i  j
     *        i   j
     *       i    j
     *         ...
     *
     * **/
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // dp[i][j] 默认值是  0
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }



}
