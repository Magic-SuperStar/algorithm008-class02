package org.geekbang.ljz.Week_02;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class Preorder {
    @Test
    public void testPreorder(){
        preorder(null);
    }
    public List<Integer> preorder(Node root) {
        LinkedList<Node> input = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;
        input.add(root);
        while (!input.isEmpty()){
            Node node = input.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                input.add(item);
            }
        }
        return output;
    }
}
