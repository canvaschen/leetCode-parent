package category.DPFS;

import common.po.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzchen
 * @create 2020-01-10
 * @desc
 *
 *
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 *
 *
 *
 *
 * 路径总和 II
 *
 **/
public class PathSum {



    /**
     * 在原先的 路径总和上 配一个 结果集
     * **/
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        hasPathSum(root,sum,res,new ArrayList<Integer>());
        return res;
    }

    /**
     * tem 只是一个中间临时值
     *
     * 结果集 需要 new
     *
     * **/
    public void hasPathSum(TreeNode root, int sum ,  List<List<Integer>> res , List<Integer> tem) {
        if (root == null){
            return ;
        }
        tem.add(root.val);
        sum = sum - root.val;
        if ((root.left == null) && (root.right == null) && sum == 0){
            res.add(new ArrayList(tem));
        }
        hasPathSum(root.left, sum,res,tem);
        hasPathSum(root.right, sum,res,tem);
        // 回溯算法的关键 , 做完就回退
        tem.remove(tem.size()-1);

    }

}
