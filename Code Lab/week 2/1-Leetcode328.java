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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        head = h;
        ListNode frontHead = new ListNode();
        ListNode newNode = new ListNode();
        frontHead = newNode;
        while ( head != null && head.next != null ) {
            newNode.next = head.next;
            head.next = head.next.next;
            newNode = newNode.next;
            head = head.next;
        }
        newNode.next = h.next;
        return frontHead.next;
    }
}