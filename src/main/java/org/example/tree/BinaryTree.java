package org.example.tree;

import org.example.linkedList.ListNode;
import org.example.model.Node;
import org.example.model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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


    /**
     * Given the root of a binary tree, return the level order traversal of its nodes' values.
     * * (i.e., from left to right, level by level).
     *Thoughts:
     *
     * This is a bread first search order traversal.
     *
     * Use two queues to remember which level currently at.
     *  
     * * * Complexity
     *
     *     Time complexity:
     *     O(n)
     *
     *     Space complexity:
     *     O(n)*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qv = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        qv.add(root);
        while (qv.size() > 0) {
            int n = qv.size();
            List<Integer> add = new LinkedList<Integer>();
            for (int i = 0; i < n; i ++) {
                TreeNode node = qv.remove();
                add.add(node.val);
                if (node.left !=null) {
                    qv.add(node.left);
                }
                if (node.right !=null) {
                    qv.add(node.right);
                }
            }
            result.add(add);
        }
        return result;
    }//l

    /**
     * Given a reference of a node in a connected undirected graph.
     *
     * Return a deep copy (clone) of the graph.
     *
     * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
     *
     * class Node {
     *     public int val;
     *     public List<Node> neighbors;
     * }
     * * * */
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        Node copy = new Node(node.val);
        dfs(copy, node, visited);
        return copy;
    }

    private void dfs(Node copy, Node node, Node[] visited){
        visited[node.val] = copy;

        for(Node n: node.neighbors){
            if(visited[n.val] == null){
                Node newNode = new Node(n.val);
                visited[n.val]=newNode;
                dfs(newNode, n, visited);
            }

            copy.neighbors.add(visited[n.val]);
        }
    }

    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
}
