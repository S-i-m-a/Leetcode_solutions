/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Create a HashSet for O(1) lookup of values to remove
        Set<Integer> toRemove = new HashSet<>();
        for (int x : nums) {
            toRemove.add(x);
        }
        
        // Dummy node to simplify edge cases (e.g., head needs removal)
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        
        // Traverse the list, skipping nodes whose value is in the set
        while (curr.next != null) {
            if (toRemove.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        
        // Return the (possibly new) head of the list
        return dummy.next;
    }
}
