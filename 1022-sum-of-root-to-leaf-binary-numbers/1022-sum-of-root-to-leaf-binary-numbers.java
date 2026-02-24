class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * Performs depth-first search to calculate binary numbers from root to leaves.
     * Builds the binary number by shifting left and adding current node's value.
     * 
     * @param node The current node being processed
     * @param currentBinaryValue The binary value accumulated from root to current node
     * @return The sum of all binary numbers in the subtree rooted at current node
     */
    private int dfs(TreeNode node, int currentBinaryValue) {
        // Base case: if node is null, contribute 0 to the sum
        if (node == null) {
            return 0;
        }
      
        // Build the binary number: shift left by 1 bit and add current node's value
        // This is equivalent to: currentBinaryValue * 2 + node.val
        currentBinaryValue = (currentBinaryValue << 1) | node.val;
      
        // If this is a leaf node, return the complete binary number
        if (node.left == null && node.right == null) {
            return currentBinaryValue;
        }
      
        // Recursively calculate sum for left and right subtrees
        return dfs(node.left, currentBinaryValue) + dfs(node.right, currentBinaryValue);
    }
}
