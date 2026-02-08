class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }


    private int height(TreeNode root) {
        // Base case: empty tree has height 0
        if (root == null) {
            return 0;
        }
      
        // Recursively calculate height of left subtree
        int leftHeight = height(root.left);
      
        // Recursively calculate height of right subtree
        int rightHeight = height(root.right);
      
        // Check if any subtree is unbalanced or height difference exceeds 1
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            // Propagate unbalanced state up the tree
            return -1;
        }
      
        // Return height of current subtree (1 + maximum child height)
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
