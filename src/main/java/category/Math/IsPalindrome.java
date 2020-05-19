package category.Math;

/**
 * @author yzchen
 * @create 2019-11-20
 * @desc
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 *  回文数
 *
 **/
public class IsPalindrome {

    public static void main(String[] args) {

        System.out.println(check(121));

    }


    public static boolean check(int x) {

        // int x , 所以 转成 long 就没有问题了 不用考虑溢出的情况
        int v1 = x;

        // 几种情况排除
        if(x<0 || (x>=10 && x%10 == 0)){
            return false;
        }

        // 正常情况
        long result=0L;
        while(x!=0){
            int p = x%10;
            x=x/10;
            result = result * 10L +p;
        }

        if(result == v1){
            return true;
        }else {
            return false;
        }

    }



}
