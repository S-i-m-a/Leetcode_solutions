/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // {robThis, skipThis}
        }
        
        // Postorder traversal: process left and right subtrees first
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        // If we rob this node, we cannot rob its children
        int robThis = node.val + left[1] + right[1];
        
        // If we skip this node, we take the maximum from robbing or skipping its children
        int skipThis = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{robThis, skipThis};
    }
}
