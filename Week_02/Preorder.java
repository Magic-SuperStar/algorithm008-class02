package org.geekbang.ljz.Week_02;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class Preorder {
    @Test
    public void testPreorder() {
        Node root = new Node(1, getNodes(new int[]{3, 2, 4}));
        for (Node node : root.children) {
            if (node.val == 3) {
                node.children = getNodes(new int[]{5, 6});
            }
        }
        List<Integer> list = preorder(root);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public LinkedList<Node> getNodes(int[] values) {
        LinkedList<Node> nodes = new LinkedList<>();
        for (int value : values) {
            nodes.add(new Node(value));
        }
        return nodes;
    }

    public List<Integer> preorder(Node root) {
        LinkedList<Node> input = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;
        input.add(root);
        while (!input.isEmpty()) {
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
