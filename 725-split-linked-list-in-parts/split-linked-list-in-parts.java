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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        
        // Step 1: Calculate the total length of the linked list
        int len = 0;
        ListNode current = head;
        while (current != null) {
            len++;
            current = current.next;
        }
        
        // Step 2: Determine the base size and the remainder
        int size = len / k;
        int extra = len % k; // Number of parts that will have one extra element
        
        current = head;
        for (int i = 0; i < k; i++) {
            if (current == null) {
                result[i] = null; // If the list is smaller than k, add null for empty parts
            } else {
                result[i] = current; // Start a new part
                int partSize = size + (extra > 0 ? 1 : 0); // This part's size
                extra--;
                
                // Move to the end of this part
                for (int j = 1; j < partSize; j++) {
                    if (current != null) {
                        current = current.next;
                    }
                }
                
                // Break the current part from the rest of the list
                if (current != null) {
                    ListNode nextPart = current.next;
                    current.next = null;
                    current = nextPart;
                }
            }
        }
        
        return result;
    }
}