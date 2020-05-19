package category.DPFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzchen
 * @create 2019-11-26
 * @desc n
 *
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 *  括号生成
 *
 *
 *
 *  回溯算法
 *
 **/
public class GenerateParenthesis {


    public static void main(String[] args) {
        List<String> res = doGenerateParenthesis(2);
        System.out.println(res);
    }

    public static List<String> doGenerateParenthesis(int n) {

        List<String> res = new ArrayList<String>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个没有用掉
     * @param right  右边的括号还有几个没有用掉
     * @param res    结果集
     */
    private static void dfs(String curStr, int left, int right, List<String> res) {
        // 因为是递归函数，所以先写递归终止条件
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 注意一下 这边情况的遍历 , 不是 类似于 for 循环那样 , 1.2.3 ... 而是从上往下同时发散下去

        // 因为每一次尝试，都使用新的字符串变量，所以没有显式的回溯过程
        // 如果左边还有剩余，继续递归下去
        if (left > 0) {
            // 拼接上一个左括号，并且剩余的左括号个数减 1
            dfs(curStr + "(", left - 1, right, res);
        }
        // 什么时候可以用右边？例如，(((((()，此时 left < right，
        // 不能用等号，因为只有先拼了左括号，才能拼上右括号
        if (right > 0 && left < right) {
            // 拼接上一个右括号，并且剩余的右括号个数减 1
            dfs(curStr + ")", left, right - 1, res);
        }
    }



}
