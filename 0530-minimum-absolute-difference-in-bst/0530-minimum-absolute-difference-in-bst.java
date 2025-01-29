public class Solution {
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;

        // Traverse the left subtree
        inOrderTraversal(root.left);

        // Check the minimum difference with the previous node
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev);
        }
        prev = root.val;

        // Traverse the right subtree
        inOrderTraversal(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
