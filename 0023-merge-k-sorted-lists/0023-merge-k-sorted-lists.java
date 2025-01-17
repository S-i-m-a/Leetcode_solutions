import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a priority queue (min-heap) to store the nodes based on their values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the first node of each list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // Create a dummy node to start the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Extract the minimum node from the heap and add it to the result list
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll(); // Get the smallest node
            current.next = node; // Add it to the merged list
            current = current.next; // Move the current pointer

            // If there is a next node in the current list, add it to the heap
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next; // Return the merged list starting from the first node
    }
}
