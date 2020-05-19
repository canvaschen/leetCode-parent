package category.DPFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yzchen
 * @create 2019-11-22
 * @desc
 **/
public class LetterCombinations {

    public static void main(String[] args) {

        System.out.println(doLetterCombinations("23"));

    }

    static Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static List<String>  result = new ArrayList<String>();

    /**
     * 深度优先算法 + 迭代
     *
     */
    public static List<String> doLetterCombinations(String digits) {

        if("".equals(digits)){
            return result;
        }

        // 回溯算法
        if (digits.length() != 0){
            backtrack("", digits);
        }
        return result;
    }


    public static void backtrack(String str, String remainNums) {

        if (remainNums.length() == 0) {
            result.add(str);
        } else {
            String num = remainNums.substring(0, 1);
            String letters = map.get(num);
            for (int i = 0; i < letters.length(); i++) {
                String letter = map.get(num).substring(i, i + 1);
                backtrack(str + letter, remainNums.substring(1));
            }
        }
    }


}
