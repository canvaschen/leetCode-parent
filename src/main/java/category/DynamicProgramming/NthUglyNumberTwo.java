package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2020-04-16
 * @desc
 *
 *
 *
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 *
 *  首先除2，直到不能整除为止，然后除5到不能整除为止，然后除3直到不能整除为止。最终判断剩余的数字是否为1，如果是1则为丑数，否则不是丑数
 *
 *  让我们从数组中只包含一个丑数数字 1 开始，使用三个指针 i2,i3,i5 , 标记所指向丑数要乘以的因子。
 *  算法很简单：在[ dp[i2]*2,dp[i3]*3,dp[i5]*5]选出最小的丑数并添加到数组中。并将该丑数对应的因子指针往前走一步。重复该步骤直到计算完 1690 个丑数。
 *  一点点往前挪,谁乘下来数值最小，谁的指针就往前挪一格
 *
 **/
public class NthUglyNumberTwo {


    public int nthUglyNumber(int n) {
        Ugly u = new Ugly();
        return u.dp[n - 1];
    }


    class Ugly {
        public int[] dp = new int[1690];
        Ugly() {

            dp[0] = 1;
            int i2 = 0, i3 = 0, i5 = 0;
            for(int i = 1; i < 1690; ++i) {
                dp[i] = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);

                if ( dp[i] == dp[i2] * 2){
                    i2++;
                }
                if ( dp[i]  == dp[i3] * 3){
                    i3++;
                }
                if ( dp[i]  == dp[i5] * 5){
                    i5++;
                }
            }
        }
    }

















}
