class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        // Swap left and right children
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        
        return root;
    }
}
