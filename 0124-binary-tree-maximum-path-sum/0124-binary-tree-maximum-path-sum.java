class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxPath(root, maxSum);
        return maxSum[0];
    }

    private int maxPath(TreeNode node, int[] maxSum) {
        if (node == null) return 0;
        
        // Recurse for left and right child, ignore negative sums
        int left = Math.max(0, maxPath(node.left, maxSum));
        int right = Math.max(0, maxPath(node.right, maxSum));
        
        // Current path sum (including node itself)
        int currentSum = left + right + node.val;
        
        // Update maxSum
        maxSum[0] = Math.max(maxSum[0], currentSum);
        
        // Return the max path sum starting from the current node
        return Math.max(left, right) + node.val;
    }
}
