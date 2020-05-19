package category.Tree;

import common.po.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yzchen
 * @create 2020-05-18
 * @desc
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 * 二叉树的前序遍历
 *
 **/
public class PreorderTraversal {


    /**
     * 迭代算法
     *
     * 有两种通用的遍历树的策略：
     *
     * 深度优先搜索（DFS）
     *
     *              在这个策略中，我们采用深度作为优先级，以便从跟开始一直到达某个确定的叶子，然后再返回根到达另一个分支。
     *
     *              深度优先搜索策略又可以根据根节点、左孩子和右孩子的相对顺序被细分为前序遍历，中序遍历和后序遍历。
     *
     * 宽度优先搜索（BFS）
     *
     *              我们按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。
     *
     * **/
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }








}
