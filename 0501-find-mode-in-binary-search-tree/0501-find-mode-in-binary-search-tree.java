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
    private Integer prev = null;  // To keep track of the previous node's value
    private int count = 0;        // Current frequency count for the current value
    private int maxCount = 0;     // The maximum frequency encountered
    private List<Integer> modes = new ArrayList<>();  // List to store the modes

    public int[] findMode(TreeNode root) {
        inorderTraversal(root);
        
        // Convert the list of modes to an array before returning
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    // In-order traversal of the tree to count frequencies
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inorderTraversal(root.left);
        
        // Process the current node
        if (prev == null || root.val != prev) {
            // If the current node value is different from the previous one, reset the count
            count = 1;
        } else {
            // If the current node value is the same as the previous one, increment the count
            count++;
        }

        // Update the maximum frequency and the modes list
        if (count > maxCount) {
            maxCount = count;
            modes.clear();  // Clear previous modes as we have a new max frequency
            modes.add(root.val);
        } else if (count == maxCount) {
            modes.add(root.val);
        }

        // Update prev to the current node's value
        prev = root.val;

        // Traverse the right subtree
        inorderTraversal(root.right);
    }
}
