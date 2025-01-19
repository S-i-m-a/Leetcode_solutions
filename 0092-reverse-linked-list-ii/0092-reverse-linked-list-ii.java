class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Edge case: If head is null or m == n (no change needed)
        if (head == null || m == n) return head;

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move `prev` to the node just before the start of the sublist
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse the sublist between m and n
        ListNode start = prev.next; // The first node of the sublist to reverse
        ListNode then = start.next; // The node that will be reversed

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;  // Remove `then` from the list
            then.next = prev.next;   // Insert `then` at the beginning of the sublist
            prev.next = then;        // Move `prev`'s next pointer to `then`
            then = start.next;       // Move `then` to the next node to reverse
        }

        return dummy.next;  // Return the modified list
    }
}
