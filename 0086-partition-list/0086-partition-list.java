public class Solution {
    public ListNode partition(ListNode head, int x) {
        // Create two dummy nodes for the two partitions
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        
        // Two pointers to track the current node of the two partitions
        ListNode less = lessHead;
        ListNode greater = greaterHead;
        
        // Traverse the list and partition the nodes
        while (head != null) {
            if (head.val < x) {
                // Append the node to the 'less' partition
                less.next = head;
                less = less.next;
            } else {
                // Append the node to the 'greater' partition
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;  // Move to the next node
        }
        
        // Connect the end of 'greater' partition to null
        greater.next = null;
        
        // Join the 'less' partition with the 'greater' partition
        less.next = greaterHead.next;
        
        // Return the new partitioned list, starting from the next of lessHead
        return lessHead.next;
    }
}
