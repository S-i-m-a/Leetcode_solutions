public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both trees are empty, they are the same
        if (p == null && q == null) {
            return true;
        }
        
        // If one of the trees is empty and the other is not, they are not the same
        if (p == null || q == null) {
            return false;
        }
        
        // Check if the values of the current nodes are the same
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
