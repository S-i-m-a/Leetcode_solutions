class Solution {
    public ListNode removeNodes(ListNode head) {
        // Step 1: Reverse the linked list
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ListNode reversedHead = prev;

        // Step 2: Remove nodes with smaller values than max
        ListNode dummy = new ListNode(0);
        dummy.next = reversedHead;
        ListNode maxNode = dummy;
        current = reversedHead;

        while (current != null) {
            if (current.val >= maxNode.val) {
                maxNode = current;
            } else {
                maxNode.next = current.next;
            }
            current = current.next;
        }

        // Step 3: Reverse the list back to the original order
        prev = null;
        current = dummy.next;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;  // New head of the list
    }
}
