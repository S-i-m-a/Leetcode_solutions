/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    // Helper method that checks the validity of the BST
    private boolean isValidBSTHelper(TreeNode root, long min, long max) {
        // If the node is null, it's a valid BST by definition
        if (root == null) {
            return true;
        }
        
        // The value of the current node must be between min and max
        if (root.val <= min || root.val >= max) {
            return false;
        }
        
        // Recursively check the left and right subtrees
        return isValidBSTHelper(root.left, min, root.val) && 
               isValidBSTHelper(root.right, root.val, max);
    }
}
