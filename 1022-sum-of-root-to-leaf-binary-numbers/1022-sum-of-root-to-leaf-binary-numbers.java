class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentBinaryValue) {
        if (node == null) {
            return 0;
        }
        currentBinaryValue = (currentBinaryValue << 1) | node.val;
        if (node.left == null && node.right == null) {
            return currentBinaryValue;
        }
        return dfs(node.left, currentBinaryValue) + dfs(node.right, currentBinaryValue);
    }
}
