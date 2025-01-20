class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        // Subtract current node's value from target sum
        targetSum -= root.val;
        
        // If it's a leaf node, check if the target sum is reached
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        
        // Recurse for both left and right subtrees
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
