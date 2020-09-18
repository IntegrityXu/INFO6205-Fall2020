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
    public ListNode partition(ListNode head, int x) {
        ListNode front = new ListNode();
        ListNode back = new ListNode();
        ListNode fHead = front;
        ListNode bHead = back;
        while ( head != null ){
            if  ( head.val < x  ) {
                front.next = head;
                head = head.next;
                front = front.next;
                front.next = null;
            }
            else {
                back.next = head;
                head = head.next;
                back = back.next;
                back.next = null;
            }
        }
        front.next = bHead.next;
        return fHead.next;
    }
}