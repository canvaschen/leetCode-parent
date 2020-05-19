package category.Tree;

import common.po.TreeNode;

/**
 * @author yzchen
 * @create 2019-12-10
 * @desc
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 *
 *  对称二叉树
 *
 **/
public class IsSymmetric {


    /**
     * 是否是镜像
     *
     * 递归
     *
     * 或者 逐层判断，第一个 和最后一个是否相同
     *
     * **/
    public boolean isSymmetric(TreeNode root) {
        return doCheck(root,root);
    }


    private boolean doCheck(TreeNode r1 , TreeNode r2){

        if(r1 == null && r2 == null){
            return true;
        }
        if(r1 == null || r2 == null){
            return false;
        }
        return (r1.val == r2.val) && doCheck(r1.left,r2.right) && doCheck(r1.right,r2.left);
    }



}



