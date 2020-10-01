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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode root = head;
        while (head != null && head.val == val) {
            root = root.next;
            head = head.next;
        }
        while (head != null &&head.next != null) {
            if (head.next.val == val) {
                head.next =head.next.next;
                continue;
            }
            head = head.next;
            //if (head == null) break;
        }
        //if (head.val == val) head = null;
        return root;
    }
}