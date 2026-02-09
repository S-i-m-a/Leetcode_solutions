class Solution {
    public TreeNode balanceBST(TreeNode root) {
        // 1. In-order traversal to get sorted values
        List<Integer> sortedValues = new ArrayList<>();
        inorder(root, sortedValues);
        
        // 2. Build a balanced BST from the sorted list
        return buildBalanced(sortedValues, 0, sortedValues.size() - 1);
    }
    
    // Collect values in sorted order
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    
    // Build a balanced BST from sorted list
    private TreeNode buildBalanced(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBalanced(list, start, mid - 1);
        node.right = buildBalanced(list, mid + 1, end);
        return node;
    }
}