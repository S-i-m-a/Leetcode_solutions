public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Create a dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // prev will be the last node that is not a duplicate
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            // Check if current node is a duplicate
            if (current.next != null && current.val == current.next.val) {
                // Skip all nodes with the same value
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Connect prev node to the next distinct node
                prev.next = current.next;
            } else {
                // Move prev to current if no duplicate
                prev = prev.next;
            }
            // Move current to the next node
            current = current.next;
        }
        
        return dummy.next;  // Return the next of dummy node (which points to the modified list)
    }
}
