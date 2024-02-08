package com.ap.leetcode.trees;

import com.ap.leetcode.common.Node;

public class LCAinBTree {

    public Node lowestCommonAncestor(Node p, Node q) {
        Node left = p;
        Node right = q;

        while(left != right) {
            left = left.parent == null ? q : left.parent;
            right = right.parent == null ? p : right.parent;
        }

        return left;
    }
}
