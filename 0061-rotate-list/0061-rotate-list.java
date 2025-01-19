public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Step 1: Edge case: If the list is empty or has one element
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 2: Get the length of the list
        ListNode temp = head;
        int length = 1;  // Start with 1 because we are already at head
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Step 3: Find the effective number of rotations
        k = k % length;
        if (k == 0) {
            return head;  // No need to rotate
        }

        // Step 4: Make the list circular
        temp.next = head;

        // Step 5: Find the new tail (n-k-1) and the new head (n-k)
        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        // Step 6: Set the new head and break the circular connection
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
