class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // If the list is empty or has only one node, no cycle
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by one step
            fast = fast.next.next;    // Move fast pointer by two steps
            
            if (slow == fast) {
                return true;          // If slow and fast meet, there's a cycle
            }
        }
        
        return false; // If we reach here, there's no cycle
    }
}
