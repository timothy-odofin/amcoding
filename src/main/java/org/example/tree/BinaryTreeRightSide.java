package org.example.tree;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * Medium
 * 9.1K
 * 542
 * Companies
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *  
 * * * **/
public class BinaryTreeRightSide {
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++)
            {
                TreeNode n = queue.poll();
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
                if (i == layerSize - 1) result.add(n.val);
            }
        }
        return result;
    }
}
/**
 * The core idea of this algorithm:
 *
 * 1.Each depth of the tree only select one node.
 * 2. View depth is current size of result list.
 * * * **/
