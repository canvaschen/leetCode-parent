package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2020-04-08
 * @desc
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 *
 * 动态规划 - 最大正方形
 *
 **/
public class MaximalSquare {

 // [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    public static void main(String [] args){

        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        maximalSquare(matrix);
    }


    /** 动态规划的核心 : 将上一步的结果存储下来 **/
    public static int maximalSquare(char[][] matrix) {

        // origin -> dp 先计算一轮
        // dp[i][j] == i，j 这个点可以形成的 最大的正方形
        // dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1

        int row = matrix.length;
        if(row == 0){
            return 0;
        }
        int col = matrix[0].length;

        // 顺序 问题:  从 上向下 .. 从左到右
        int [][] dp = new int[row][col];
        int  result = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                // 分情况讨论
                // 第一行
                if(i==0 || j==0){
                    dp[i][j] = Integer.parseInt(matrix[i][j]+"");
                }else {
                    dp[i][j] = Integer.parseInt(matrix[i][j]+"") == 0 ? 0 : Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) + 1;
                }
                result = Math.max(result,dp[i][j]);
            }
        }
        return result*result;
    }















}
