import java.util.HashMap;

class Solution {
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store inorder values with their indices for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int left, int right) {
        if (left > right) return null;

        // Pick the current root from preorder
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder array
        int inorderIndex = inorderMap.get(rootValue);

        // Recursively construct left and right subtrees
        root.left = buildTreeHelper(preorder, left, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorderIndex + 1, right);

        return root;
    }
}
