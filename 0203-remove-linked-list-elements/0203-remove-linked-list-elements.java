class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle the edge case for the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode current = dummy;
        
        // Traverse through the list
        while (current.next != null) {
            if (current.next.val == val) {
                // Remove the node
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }
        
        return dummy.next;  // Return the next node after dummy, which is the new head
    }
}
