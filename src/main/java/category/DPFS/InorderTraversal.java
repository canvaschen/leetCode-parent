package category.DPFS;

import common.po.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzchen
 * @create 2020-01-08
 * @desc
 *
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 *
 * 二叉树的中序遍历
 *
 **/
public class InorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }


    /**
     * 递归: 中序遍历 , 根节点在中间
     **/
    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper(root.right, res);
        }
    }


}
