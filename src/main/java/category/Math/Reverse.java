package category.Math;

/**
 * @author yzchen
 * @create 2019-11-19
 * @desc 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 *
 *
 * Integer类取值和 int 类型取值一致，取值范围是从-2147483648 至 2147483647（-231至 231-1） ，包括-2147483648 和 2147483647
 *
 **/
public class Reverse {


    public static void main(String[] args) {

        System.out.println(doReverse(1534236469));

//        System.out.println(964632435 * 10L + 1);

    }


    /**
     * 主要需要考虑 溢出的情况
     **/
    public static int doReverse(int x) {
        int result = 0;

        while (x != 0) {

            int p1 = x % 10;
            x = x / 10;

            // 判断溢出的情况:
            if(result * 10L + p1 > Integer.MAX_VALUE){
                return 0;
            }

            if(result * 10L + p1 < Integer.MIN_VALUE){
                return 0;
            }
            System.out.println(result + " --  "  + x + " -- " + p1);
            result = result * 10 + p1;
        }
        return result;
    }
}
