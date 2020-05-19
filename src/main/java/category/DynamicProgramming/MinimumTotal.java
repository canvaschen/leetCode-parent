package category.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzchen
 * @create 2020-01-10
 * @desc
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 *
 * 本题的描述 有一些 歧义 : 本题想表达的意思 应该是 类似于 图的寻址
 *
 **/
public class MinimumTotal {

    public static void main(String [] args){

        List<Integer> l1 = new ArrayList<>();
        l1.add(2);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);

        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);

        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);

        System.out.println(minimumTotal(triangle));


    }

    static Integer[][] dp;

    static int row;

    public static int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size();
        dp = new Integer[row][row];
        return helper(0,0,triangle);
    }


    /**
     *
     * 直接做 会超时 : 优化一下 ，用记忆法
     *
     * 递归 + 动态规划
     *
     *  n 层 的 第 i 个数据 的最短路径
     *
     *  n , i 的范围 : 0 ，1，2，3
     *
     *  返回值就是 路径的值
     *
     * 自顶向下
     *
     * 返回 0,0
     *
     * **/
    private static int helper(int n , int i, List<List<Integer>> triangle){

        if(dp[n][i] != null){
            return dp[n][i];
        }

        if(n==row-1){
            // 最底层的 dp 值
            return dp[n][i] = triangle.get(n).get(i);
        }

        // 中间层
        int v1 = triangle.get(n).get(i);
        int p1 = helper(n+1,i,triangle);
        int p2 = helper(n+1,i+1,triangle);
        dp[n][i] = v1+ (p1>p2?p2:p1);
        return   dp[n][i];
    }












}
