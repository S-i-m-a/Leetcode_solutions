class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // Deserialize a string to a ListNode
    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("[]")) {
            return null;
        }

        // Remove the brackets
        data = data.substring(1, data.length() - 1);
        String[] values = data.split(",");

        // Create the head node
        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode current = head;

        // Create subsequent nodes
        for (int i = 1; i < values.length; i++) {
            ListNode newNode = new ListNode(Integer.parseInt(values[i]));
            current.next = newNode;
            current = newNode;
        }

        return head;
    }

    // Serialize ListNode to string (for testing purposes)
    public static String serialize(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(",");
            }
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Base case: if the head is null or there are fewer than k nodes, return head
        if (head == null || k == 1) return head;

        // Create a dummy node to simplify the head reversal
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        // Count the number of nodes in the list
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Reverse the list in groups of k
        current = head;
        while (length >= k) {
            ListNode groupStart = current;
            ListNode groupEnd = current;
            // Move groupEnd to the k-th node
            for (int i = 1; i < k; i++) {
                groupEnd = groupEnd.next;
            }
            // Save the next group start
            ListNode nextGroupStart = groupEnd.next;

            // Disconnect the current group from the next group
            groupEnd.next = null;

            // Reverse the current group
            ListNode prev = null;
            ListNode temp = groupStart;
            while (temp != null) {
                ListNode nextNode = temp.next;
                temp.next = prev;
                prev = temp;
                temp = nextNode;
            }

            // Connect the previous part of the list to the reversed group
            prevGroupEnd.next = prev;
            groupStart.next = nextGroupStart;

            // Move prevGroupEnd and current to the next group
            prevGroupEnd = groupStart;
            current = nextGroupStart;

            // Decrease the length by k
            length -= k;
        }

        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage:

        // Deserialize input linked list: [1, 2, 3, 4, 5]
        String input = "[1,2,3,4,5]";
        ListNode head = ListNode.deserialize(input);

        // Reverse the list in groups of k
        Solution solution = new Solution();
        int k = 3;  // Example k value
        ListNode newHead = solution.reverseKGroup(head, k);

        // Serialize and print the modified list
        String output = ListNode.serialize(newHead);
        System.out.println(output);  // Output: [3,2,1,4,5] for k = 3
    }
}
