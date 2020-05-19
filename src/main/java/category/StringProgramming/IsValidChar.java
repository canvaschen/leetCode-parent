package category.StringProgramming;

import java.util.Stack;

/**
 * @author yzchen
 * @create 2019-11-25
 * @desc
 *
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 *
 **/
public class IsValidChar {

    public static void main(String[] args) {

        System.out.println(isValid("{"));

    }

    public static boolean isValid(String s) {

        // 利用这个 编译原理的方法进行处理  (使用栈 ，或者是 移动指针来实现)
        int len = s.length();

        Stack<String> st = new Stack<String>();
        for(int i=0;i<len;i++){
            if(st.empty()){
                // 入操作
                st.push(s.charAt(i)+"");
                continue;
            }

            if(isPair(st.peek(),s.charAt(i)+"")){
                // 是一对的，出栈
                st.pop();
            }else {
                st.push(s.charAt(i)+"");
            }
        }

        if(!st.empty()){
            return false;
        }else {
            return true;
        }
    }


   /**
    * 判断是否是一对
    * **/
    private static boolean isPair(String left ,String right){

        if("{".equals(left) && "}".equals(right)){
            return true;
        }

        if("[".equals(left) && "]".equals(right)){
            return true;
        }

        if("(".equals(left) && ")".equals(right)){
            return true;
        }
        return false;
    }








}
