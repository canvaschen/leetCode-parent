package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2019-11-28
 * @desc
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *
 * 最大子序和
 *
 **/
public class MaxSubArray {


    /**
     * 1.定义子问题
     * 2.写出子问题的递推关系
     * 3.确定 DP 数组的计算顺序
     * 4.空间优化（可选）
     * **/
    public int maxSubArray(int[] nums) {

        // f(k) = max(f(k-1),0) + f(k-1);
        // k 可以理解为 每一次的计算
        // dp 数组用来存储 计算的结果

        int N = nums.length;
        int [] dp = new int[N+1];
        dp[0]=0;
        int result = Integer.MIN_VALUE;
        for(int k=1;k<=N;k++){
            dp[k]=Math.max(dp[k-1],0)+ nums[k-1];
            result = Math.max(dp[k],result);
        }
        return result;
    }



}
