package com.ap.leetcode.trees;

import com.ap.leetcode.common.TreeNode;

/**
 * LC: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class LCAinBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
