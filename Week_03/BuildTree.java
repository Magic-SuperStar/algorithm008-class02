package org.geekbang.ljz.Week_03;

import org.junit.Test;


public class BuildTree {

    @Test
    public void testBuildTree() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode tree = buildTree(preorder, inorder);
        System.out.println("从前序与中序遍历序列构造二叉树:" + tree.toString());
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length <= 0 || inorder == null || inorder.length <= 0) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        //终止条件：recursion terminator
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        //处理当前逻辑

        //重建根节点
        TreeNode root = new TreeNode(preorder[pStart]);
        //找到根节点在中序遍历的位置
        int index = 0;
        while (inorder[iStart + index] != preorder[pStart]) {
            index++;
        }
        //重建左子树
        root.left = helper(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
        //重建右子树
        root.right = helper(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
        return root;
    }
}
