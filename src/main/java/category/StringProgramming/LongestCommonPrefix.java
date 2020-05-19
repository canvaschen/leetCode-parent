package category.StringProgramming;

/**
 * @author yzchen
 * @create 2019-11-21
 * @desc
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 *
 * 最长公共前缀
 *
 **/
public class LongestCommonPrefix {

    /**
     * 一遍扫描法
     *
     * LCP(S1..Sn) = LCP(LCP(LCP(S1,S2),S3),...Sn)
     *
     * 算出 S1,S2 的共串 prefix
     * 算出 prefix 和 S3 的共串 prefix
     * ....
     *
     * 因为要求是最长子序
     *
     *
     * **/


    public static void main(String [] args){

//        String [] sss = {"caas","ca","caa","caaq"};
//
//        doLongestCommonPrefix(sss);

        String s = "ca";
        System.out.println(s.indexOf("caas"));



    }




    private static String doLongestCommonPrefix(String [] strs){

        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            // 出现在首位，直接 过
            // 出现在 中间位置 或者不出现 , 就对 prefix 进行编辑
            while (strs[i].indexOf(prefix) != 0) {
                // 然后 一位位的截取
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }






}
