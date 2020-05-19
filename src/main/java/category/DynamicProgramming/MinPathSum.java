package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2019-12-03
 * @desc
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 最小路径和
 *
 **/
public class MinPathSum {


    /**
     * 二维数组的动态规划
     * **/
    public int minPathSum(int[][] grid) {
        // 为什么要逆向 : 对于 边而言 , 回退的路径只有一种可能 。 如果是 正向, 则会有 两种分支出来
        // dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))
        // 从下往上 ， 逆向
        // 行
        int row = grid.length;
        // 列
        int col = grid[0].length;

        int[][] dp = new int[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {

                // 设置 dp 的值
                if(i == row - 1 && j != col - 1){
                    // 底边
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];

                } else if(i != row - 1 && j == col - 1){
                    // 右侧边
                    dp[i][j] = grid[i][j] + dp[i + 1][j];

                } else if(i != row - 1 && j != col - 1){
                    // 中间
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);

                } else{
                    // 就是顶点
                    dp[i][j] = grid[i][j];
                }

            }
        }
        return dp[0][0];
    }





























}
