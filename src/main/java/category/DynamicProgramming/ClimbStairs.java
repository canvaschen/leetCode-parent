package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2020-04-07
 * @desc
 *
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 *  爬楼梯
 *
 **/
public class ClimbStairs {


    public static int climbStairs(int n) {

        // 避免重复计算 .. 将 结果记录起来
        //f(0) = 0 , f(1) = 1 , f(2) = 2 , f(n) = f(n-1) + f(n-2)
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int [] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for(int i=3 ;i<=n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }











}
