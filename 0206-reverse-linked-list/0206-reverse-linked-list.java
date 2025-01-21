class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // The previous node, initially null
        ListNode curr = head; // The current node, starting at the head
        
        while (curr != null) {
            ListNode next = curr.next; // Temporarily store the next node
            curr.next = prev;         // Reverse the current node's pointer
            prev = curr;              // Move prev to the current node
            curr = next;              // Move curr to the next node
        }
        
        return prev; // Prev is the new head of the reversed list
    }
}
