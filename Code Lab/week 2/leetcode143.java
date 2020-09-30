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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode f = head;
        ListNode s = head.next;
        while (s != null && s.next != null) {
            f = f.next;
            s = s.next.next;
        }
        ListNode tail = f;
        f = f.next;
        tail.next = null;
        s = null;
        while (f != null) {
            ListNode tmp = f.next;
            f.next = s;
            s = f;
            f = tmp;
        }
        f = head;
        while (f != null && s != null) {
            ListNode tmp1 = f.next;
            ListNode tmp2 = s.next;
            f.next = s;
            s.next = tmp1;
            f = tmp1;
            s = tmp2;
        }
    }
}