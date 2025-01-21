class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // A single-node or empty list is always a palindrome
        }

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow);

        // Step 3: Compare the first half and the reversed second half
        ListNode firstHalf = head;
        ListNode reversedHalf = secondHalf;
        boolean isPalindrome = true;

        while (reversedHalf != null) {
            if (firstHalf.val != reversedHalf.val) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            reversedHalf = reversedHalf.next;
        }

        // Step 4: Restore the list (optional)
        reverseList(secondHalf);

        return isPalindrome;
    }

    // Helper function to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
