package org.example.tree;

import org.example.model.TreeNode;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * * * */
public class InverseATree {
    private TreeNode recursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        recursion(root.left);
        recursion(root.right);
        return root;
    }
    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        return lca(root, min, max);
    }
    private TreeNode lca(TreeNode root, int min, int max) {
        if (root.val >= min && root.val <= max) {
            return root;
        }
        if (root.val > max) {
            return lca(root.left, min, max);
        }
        if (root.val < min) {
            return lca(root.right, min, max);
        }
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        else {
            return right;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root) > 0;
    }
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
