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
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            // Nodes to be swapped
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap the nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev to the next pair
            prev = first;
        }

        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        // Deserialize input linked list: [1, 2, 3, 4]
        String input = "[1,2,3,4]";
        ListNode head = ListNode.deserialize(input);

        // Swap pairs
        Solution solution = new Solution();
        ListNode newHead = solution.swapPairs(head);

        // Serialize and print the swapped list
        String output = ListNode.serialize(newHead);
        System.out.println(output);  // Output: [2,1,4,3]
    }
}
