/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return constructBST(head, null);
    }

    private TreeNode constructBST(ListNode start, ListNode end) {
        if (start == end) {
            return null; // Base case: no elements to construct the subtree
        }

        // Find the middle node
        ListNode mid = findMiddle(start, end);

        // Create the root node
        TreeNode root = new TreeNode(mid.val);

        // Recursively build the left and right subtrees
        root.left = constructBST(start, mid);
        root.right = constructBST(mid.next, end);

        return root;
    }

    private ListNode findMiddle(ListNode start, ListNode end) {
        ListNode slow = start;
        ListNode fast = start;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Middle element
    }
}
