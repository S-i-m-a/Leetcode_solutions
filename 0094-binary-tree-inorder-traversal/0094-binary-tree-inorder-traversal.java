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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    private void inorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        // Traverse the left subtree
        inorderHelper(root.left, result);
        
        // Visit the current node
        result.add(root.val);
        
        // Traverse the right subtree
        inorderHelper(root.right, result);
    }
}
