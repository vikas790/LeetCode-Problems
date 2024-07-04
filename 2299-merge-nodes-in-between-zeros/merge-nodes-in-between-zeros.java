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
    public ListNode mergeNodes(ListNode head) {
        ListNode x = new ListNode(0);
        ListNode curr = x;
        int tmp = 0;

        while (head != null) {
            if (head.val == 0) {
                if (tmp != 0) {
                    curr.next = new ListNode(tmp);
                    curr = curr.next;
                    tmp = 0;
                }
            } else {
                tmp += head.val;
            }
            head = head.next;
        }

        return x.next;
    }
}