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
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {         
        ListNode head = new ListNode();
        ListNode prev = head;
        int carry = 0;
        while(L1 != null || L2 != null || carry != 0){
            int op1 = 0;
            int op2 = 0;
            if (L1 != null) {
                op1 = L1.val;
                L1 = L1.next;
            }
            if (L2 != null) {
                op2 = L2.val;
                L2 = L2.next;
            }
            int sum = op1 + op2 + carry;
            carry = sum / 10;
            ListNode result = new ListNode(sum - carry * 10); 
            prev.next = result;
            prev = result;
        }
        return head.next;
    }
}
