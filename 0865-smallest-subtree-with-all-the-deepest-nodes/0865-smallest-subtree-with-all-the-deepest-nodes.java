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
    // Helper class to hold a pair (node, depth)
    private static class Result {
        TreeNode node;
        int depth;
        Result(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
    // Returns a Result where:
    // - depth = maximum depth in this subtree
    // - node = smallest subtree root containing all deepest nodes
    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }
        
        Result leftR = dfs(root.left);
        Result rightR = dfs(root.right);
        
        // If left and right depths are equal, root is the LCA of deepest nodes
        if (leftR.depth == rightR.depth) {
            return new Result(root, leftR.depth + 1);
        }
        
        // Otherwise pick the deeper subtree’s candidate
        if (leftR.depth > rightR.depth) {
            return new Result(leftR.node, leftR.depth + 1);
        } else {
            return new Result(rightR.node, rightR.depth + 1);
        }
    }
}
