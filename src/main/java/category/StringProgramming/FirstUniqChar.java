package category.StringProgramming;

import java.util.HashMap;

/**
 * @author yzchen
 * @create 2020-05-15
 * @desc
 *
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *  
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 *
 * 字符串中的第一个唯一字符
 *
 **/
public class FirstUniqChar {

    /**
     *
     * 常规算法 : 先统计次数，再取数
     *
     * **/
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }





}
