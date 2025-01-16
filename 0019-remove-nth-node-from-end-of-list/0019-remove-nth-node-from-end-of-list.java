public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Two pointers: 'first' will be n+1 steps ahead of 'second'
        ListNode first = dummy;
        ListNode second = dummy;

        // Move 'first' pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until 'first' reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // 'second.next' is the node to be deleted, so we update its next pointer
        second.next = second.next.next;

        // Return the head of the updated list (dummy.next)
        return dummy.next;
    }
}
