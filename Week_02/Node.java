package org.geekbang.ljz.Week_02;

import java.util.LinkedList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.children=new LinkedList<>();
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
