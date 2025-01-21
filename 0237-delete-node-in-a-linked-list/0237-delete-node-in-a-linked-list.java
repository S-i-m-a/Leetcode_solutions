class Solution {
    public void deleteNode(ListNode node) {
        // Copy the value of the next node to the current node
        node.val = node.next.val;
        
        // Skip the next node by pointing the current node's next to the next node's next
        node.next = node.next.next;
    }
}
