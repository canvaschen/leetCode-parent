package category.Tree;

import common.po.TreeNode;

/**
 * @author yzchen
 * @create 2019-12-05
 * @desc
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 **/
public class InvertTree {

    /**
     *
     * 这道题很适合递归来处理
     *
     * 这边需要用到中间值 : right , left
     *
     * **/
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

}