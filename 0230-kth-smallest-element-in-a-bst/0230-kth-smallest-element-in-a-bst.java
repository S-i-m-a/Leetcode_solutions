/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private int count = 0;  // Keeps track of the number of nodes visited
    private int result = 0; // Stores the kth smallest element
    
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }
    
    // In-order traversal of the tree
    private void inorderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        
        // Traverse the left subtree
        inorderTraversal(root.left, k);
        
        // Visit the current node
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        
        // Traverse the right subtree
        inorderTraversal(root.right, k);
    }
}
