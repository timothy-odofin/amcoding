package org.example.tree;

import org.example.linkedList.ListNode;
import org.example.model.TreeNode;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * * * */
public class BinaryTree {
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
    public ListNode reverseList(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode node = head;
        while (node != null){
            ListNode nodeNext = node.next;
            node.next = fakeHead.next;
            fakeHead.next = node;
            node = nodeNext;
        }
        return fakeHead.next;
    }
/**
 * 543 Diameter of Binary Tree
 * Problem:
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * * The diameter of a binary tree is the length of the longest path between any
 * * two nodes in a tree. This path may or may not pass through the root.
 *
 * Example: Given a binary tree
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * * * */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        res[0] = 0;
        process(root, res);
        return res[0];
    }
    private int process(TreeNode node, int[] res) {
        if (node == null) {
            return -1;
        }
        int left = process(node.left, res) + 1;
        int right = process(node.right, res) + 1;
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right);
    }
/**
 * But we have to add root as well. So, it will be 3 + 1 = 4
 *
 * Now let's code it up
 * ANALYSIS :-
 *
 *     Time Complexity :- BigO(N)
 *
 *     Space Complexity :- BigO(N)*
 *      the space complexity should be O(log(N))*
 * * * */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
