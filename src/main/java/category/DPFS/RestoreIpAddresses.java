package category.DPFS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yzchen
 * @create 2020-01-04
 * @desc
 *
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 *  
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 *
 * 复原IP地址
 *
 **/
public class RestoreIpAddresses {


    public static List<String> restoreIpAddresses(String s) {
        if (s == null || "".equals(s.trim())) {
            return Collections.emptyList();
        }
        List<String> ans = new LinkedList<>();
        dfs(ans, s, 0, new StringBuilder(), 0);
        return ans;
    }

    /**
     *
     * 回溯算法
     * ans 结果集
     * s: 原始字符串
     * num : 计数器
     *
     * **/
    private static void dfs(List<String> ans, String s, int start, StringBuilder ip, int num) {
        if (num > 4) {
            return;
        }
        if (start == s.length()) {
            if (num == 4) {
                ans.add(ip.substring(1));
            }
            return;
        }
        for (int end = start + 1; end <= s.length() && end <= start + 3; end++) {
            if (end - start > 1 && s.charAt(start) == '0') {
                return;
            }
            int n = Integer.parseInt(s.substring(start, end));
            if (n < 256) {
                ip.append(".").append(n);
                dfs(ans, s, end, ip, num + 1);
                ip.delete(ip.lastIndexOf("."), ip.length());
            }
        }
    }


}
