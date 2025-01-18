// TreeNode class as a separate class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        // Perform the in-order traversal to find the two swapped nodes
        inOrderTraversal(root);
        
        // Swap the values of the two nodes to fix the BST
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    
    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        
        // Traverse the left subtree
        inOrderTraversal(root.left);
        
        // Detect violations
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev; // First violation: previous node
            }
            second = root; // Second violation: current node
        }
        
        // Update previous node for next comparison
        prev = root;
        
        // Traverse the right subtree
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example: Create a BST with swapped nodes
        TreeNode root = new TreeNode(3);  // No need for Solution.TreeNode anymore
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        
        // Call recoverTree to fix the tree
        solution.recoverTree(root);

        // After fixing the tree, the values should be restored
        // Output or verification code can go here
    }
}
