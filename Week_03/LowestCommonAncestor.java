package org.geekbang.ljz.Week_03;


import org.junit.Test;

public class LowestCommonAncestor {
    @Test
    public void TestLowestCommonAncestor() {
        //3,5,1,6,2,0,8,null,null,7,4
        TreeNode root = null;
        TreeNode p = null;
        TreeNode q = null;
        TreeNode node = lowestCommonAncestor(root, p, q);
    }

    //递归终结条件：recursion terminator
//        if(level>max_level){
//        procees_result
//        return ;
//    }
    //处理当前层逻辑：procees logic in current level
//    process(level,data...);
    //下探到下一层：drill level
//    resursion(level,p1...);
    //清理当前：reserse the current level status if needed
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //p,q,是否存在于root
        //然后 遍历 公共的root
        //找到最近的root
        //终止条件：recursion terminator
        if (root == null || root == p || root == q) return root;
        //处理当前层逻辑：process logic in the current level
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
