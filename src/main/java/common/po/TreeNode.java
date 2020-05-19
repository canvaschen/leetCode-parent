package common.po;

import lombok.Data;

/**
 * @author yzchen
 * @create 2020-04-03
 * @desc
 **/
@Data
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


}
