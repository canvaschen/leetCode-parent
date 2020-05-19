package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2020-04-09
 * @desc
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 最长上升子序列
 *
 * 子序列(subsequence)：字符串的子序列值的是字符串中几个顺序一致的字符组成的序列，例如：string = "12345"，那么"12", "135"和“45”都是子序列。注意到，一个字符串的子序列的集合一定涵盖了该字符串子串的集合。
 *
 * 子串(substring)：字符串的子串指的是字符串中连续几个字符组成的序列，例如：string = "12345"，那么"12", "234"和“45”都是子串。对于Java而言，String.subString()便提供了子串截取的方法。
 *
 *
 **/
public class LengthOfLIS {


    public static void main(String [] args){

        int [] aa = {10,9,2,5,3,7,101,18};
        lengthOfLIS(aa);
    }

    /** 动态规划
     *
     * 关于 一维 dp[] : inner 内的比较 ，递增
     *     二维 dp[][] : public, 公共的 比较 ， 相同
     *
     *  定义 dp[i]dp[i] 为考虑前 ii 个元素，以第 ii 个数字结尾的最长上升子序列的长度，注意 \textit{nums}[i]nums[i] 必须被选取。
     *
     *   dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
     *
     *   dp[i] 表示长度
     *
     *
     *   这个 题解 还是有点不太好理解
     * **/
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {

            // 统计前面 j 个数据里的最大长度
            int innerMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    innerMax = Math.max(innerMax, dp[j]);
                }
            }
            dp[i] = innerMax + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }










}
