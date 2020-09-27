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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode h = head;
        while (h != null) {
            int m1 = m;
            int n1 = n;
            while (h.next != null && m1 > 1) {
                h = h.next;
                m1 --;
            }
            while (h.next != null && n1 != 0) {
                h.next = h.next.next;
                n1 --;
            }
            h = h.next;
        }
        return head;
    }
}