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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode();
        root.next = head;
        head = root;
        while (head.next != null && head.next.next != null) {
            ListNode tmp1 = head.next.next;
            ListNode tmp2 = head.next;
            head.next = tmp1;
            tmp2.next = tmp1.next;
            tmp1.next = tmp2;
            head = tmp2;
        }
        return root.next;
    }
}