public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Calculate the length of the linked list
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        // Step 2: Calculate the base size of each part and the extra nodes
        int partSize = length / k;
        int extraParts = length % k;
        
        // Step 3: Create an array to store the resulting parts
        ListNode[] result = new ListNode[k];
        
        // Step 4: Split the list into parts
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            // Step 4a: Set the head for this part
            result[i] = current;
            
            // Step 4b: Calculate the size of the current part
            int currentPartSize = partSize + (i < extraParts ? 1 : 0);
            
            // Step 4c: Move the current pointer to the end of the current part
            for (int j = 1; j < currentPartSize; j++) {
                if (current != null) {
                    current = current.next;
                }
            }
            
            // Step 4d: Break the current part from the rest of the list
            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }
        }
        
        return result;
    }
}
