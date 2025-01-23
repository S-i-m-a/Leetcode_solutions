class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound) {
            return null;
        }

        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);

        // Recursively build the left subtree, setting the current root's value as the new bound.
        root.left = helper(preorder, rootVal);

        // Recursively build the right subtree with the original bound.
        root.right = helper(preorder, bound);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
