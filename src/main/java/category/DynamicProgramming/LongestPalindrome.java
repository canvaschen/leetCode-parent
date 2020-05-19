package category.DynamicProgramming;

/**
 * @author yzchen
 * @create 2019-05-30
 * @desc 最长回文字段
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 *
 *
 *
 * 阿里 ，腾讯 ，字节跳动
 *
 **/
public class LongestPalindrome {

    public static void main(String[] args) {

        System.out.println(dynamicProgramming("babad"));

        System.out.println(dynamicProgramming("cbbd"));

        System.out.println(dynamicProgramming("aaa"));

        System.out.println(dynamicProgramming("aa"));

        System.out.println(dynamicProgramming("a"));

        System.out.println(dynamicProgramming("aaab"));

        System.out.println(dynamicProgramming("ababb"));

        System.out.println(dynamicProgramming("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));

    }

    /**
     * 动态规划  n * n  , 倒序处理
     **/
    private static String dynamicProgramming(String s) {
        int len = s.length();
        if (len == 0) {
            return s;
        }
        int max = 0;
        String result = "";
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {

                // j+1 > = i-1 这时, 就可以结束了
                // j+1 < i-1 这是正常情况，这时去判断 dp[j+1][i-1]
                // check 的过程
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    // 记忆一下
                    dp[j][i] = true;
                    if (i - j + 1 > max) {
                        max = s.substring(j, i + 1).length();
                        result = s.substring(j, i + 1);
                    }
                }
            }
        }
        return result;

    }

}
