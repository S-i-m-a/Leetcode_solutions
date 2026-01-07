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
    private long maxProduct = 0;
    private long totalSum = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // 1) Calculate total sum of all nodes
        totalSum = computeSum(root);

        // 2) Traverse again to compute each subtree and track max product
        computeMaxProduct(root);

        // 3) Return result % (10^9+7)
        return (int)(maxProduct % MOD);
    }

    // DFS to compute total sum of the tree
    private long computeSum(TreeNode node) {
        if (node == null) return 0;
        long left = computeSum(node.left);
        long right = computeSum(node.right);
        return node.val + left + right;
    }

    // DFS post order to compute each subtree sum and update max product
    private long computeMaxProduct(TreeNode node) {
        if (node == null) return 0;

        long leftSum = computeMaxProduct(node.left);
        long rightSum = computeMaxProduct(node.right);

        long subtreeSum = node.val + leftSum + rightSum;

        // Here we compute product of splitting at this point
        long product = subtreeSum * (totalSum - subtreeSum);
        if (product > maxProduct) {
            maxProduct = product;
        }

        return subtreeSum;
    }
}
