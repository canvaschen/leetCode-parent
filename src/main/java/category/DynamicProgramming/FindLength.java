package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2020-04-17
 * @desc
 *
 *
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 *
 * 最长重复子数组
 *
 *
 **/
public class FindLength {







    /**
     * 状态转移方程 dp[i][j] : 从 i, j 开始的最大长度
     *
     *   如果 A[i] == B[j] ,  dp[i][j] = dp[i+1][j+1] + 1
     *
     *   dp[][] 二维数组
     *
     *   顺序: 从后往前
     *
     *
     * **/
    public static int findLength(int[] A, int[] B) {
        int al = A.length;
        int bl = B.length;
        int maxValue = 0;
        int [][] dp = new int[al+1][bl+1];
        for(int i= al-1;i>=0;i--){
            for(int j= bl-1;j>=0;j--){
                if(A[i] == B[j]){
                    dp[i][j] = dp[i+1][j+1] + 1;
                    maxValue = Math.max(maxValue,dp[i][j]);
                }
            }
        }
        return maxValue;
    }



    public static void main(String [] args){

        int [] A = {1,2,3,2,1};
        int [] B = {3,2,1,4,7};

        System.out.println(findLength(A,B));


    }



}
