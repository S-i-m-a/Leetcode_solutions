class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;  // If the list has only one node, return null
        }
        
        // Step 1: Find the middle node using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;  // This will keep track of the node before the middle node
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // Move fast pointer by 2 steps
            prev = slow;            // Move prev to the current slow
            slow = slow.next;       // Move slow pointer by 1 step
        }
        
        // Step 2: Delete the middle node
        prev.next = slow.next;
        
        return head;
    }
}
