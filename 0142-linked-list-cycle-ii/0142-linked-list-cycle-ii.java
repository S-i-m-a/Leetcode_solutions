class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle if the list is empty or has only one node
        }

        ListNode slow = head;
        ListNode fast = head;
        
        // Step 1: Detect cycle using Tortoise and Hare algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move slow pointer by 1 step
            fast = fast.next.next;      // Move fast pointer by 2 steps
            
            if (slow == fast) {         // Cycle detected
                // Step 2: Find the start of the cycle
                ListNode start = head;
                while (start != slow) {
                    start = start.next;  // Move start pointer by 1 step
                    slow = slow.next;    // Move slow pointer by 1 step
                }
                return start;  // start is now the beginning of the cycle
            }
        }
        
        return null; // No cycle detected
    }
}
