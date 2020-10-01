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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode f = new ListNode();
        f.next = head;
        ListNode s = f.next;
        head = f;
        while ( s.next != null ) {
            if (f.next.val != s.next.val) {
                f = s;
                s = s.next;
                continue;
            }
            while (s.next != null && f.next.val == s.next.val) {
                s = s.next;
            }
            if (s.next == null) {
                f.next = null;
                break;
            }
            f.next = s.next;
            s = f.next;
            
        }
        return head.next;
    }
}