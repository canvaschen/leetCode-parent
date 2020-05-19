package category.DynamicProgramming;


import common.po.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yzchen
 * @create 2020-04-03
 * @desc
 *
 * 不同的搜索二叉树
 *
 *
 **/
public class GenerateTrees {

    /** 不同的搜索二叉树 (递归) **/
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> pre = new ArrayList<TreeNode>();
        if (n == 0) {
            return pre;
        }
        pre.add(null);
        //每次增加一个数字
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            //遍历之前的所有解
            for (TreeNode root : pre) {
                //插入到根节点
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);
                //插入到右孩子，右孩子的右孩子...最多找 n 次孩子
                for (int j = 0; j <= n; j++) {
                    //复制当前的树
                    TreeNode root_copy = treeCopy(root);
                    //找到要插入右孩子的位置
                    TreeNode right = root_copy;
                    int k = 0;
                    //遍历 j 次找右孩子
                    for (; k < j; k++) {
                        if (right == null){
                            break;
                        }
                        right = right.right;
                    }
                    //到达 null 提前结束
                    if (right == null)
                        break;
                    //保存当前右孩子的位置的子树作为插入节点的左孩子
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    //右孩子是插入的节点
                    right.right = insert;
                    //插入节点的左孩子更新为插入位置之前的子树
                    insert.left = rightTree;
                    //加入结果中
                    cur.add(root_copy);
                }
            }
            pre = cur;
        }
        return pre;
    }


    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }








}
