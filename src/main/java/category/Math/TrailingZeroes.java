package category.Math;

/**
 * @author yzchen
 * @create 2020-01-16
 * @desc
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 *
 * 阶乘后的零
 *
 **/
public class TrailingZeroes {



    /**
     * 统计一个 阶乘 中 出现 包含的5 的个数
     *
     * 因为 2 出现的频率 比 5 大 .. 所以 .. 统计 5 就可以
     *
     * 由于很容易超限 .. 所以 .. 可以考虑 记忆算法
     *
     * n / 5 + n / 25 + n / 125
     * **/
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }




}
