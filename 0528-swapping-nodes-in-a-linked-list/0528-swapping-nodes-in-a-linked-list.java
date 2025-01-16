class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // Deserialize method to convert a string to a linked list
    public static ListNode deserialize(String str) {
        if (str == null || str.isEmpty() || str.equals("[]")) {
            return null;
        }

        str = str.substring(1, str.length() - 1);  // Remove brackets
        String[] values = str.split(",");

        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(Integer.parseInt(values[i]));
            current = current.next;
        }

        return head;
    }

    // Print list to standard output
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Solution {
    // Function to find the length of the linked list
    public int getLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // Function to swap the kth node from the beginning and the kth node from the end
    public ListNode swapNodes(ListNode head, int k) {
        int length = getLength(head);

        // Find the kth node from the beginning
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Find the kth node from the end
        ListNode second = head;
        for (int i = 1; i < length - k + 1; i++) {
            second = second.next;
        }

        // Swap the values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
        
    }
}
